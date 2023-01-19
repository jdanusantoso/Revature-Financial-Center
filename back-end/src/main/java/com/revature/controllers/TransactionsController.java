package com.revature.controllers;

import com.revature.daos.AccountsDAO;
import com.revature.daos.TransactionsDAO;
import com.revature.models.Accounts;
import com.revature.models.Transactions;
import com.revature.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //This combines @Controller and @ResponseBody
@CrossOrigin //lets us take in HTTP requests (might have to specify ports in your P2)
@RequestMapping(value="/transactions")
public class TransactionsController {

    private final TransactionsDAO tDAO;

    @Autowired
    public TransactionsController(TransactionsDAO tDAO) {
        super();
        this.tDAO = tDAO;
    }

    //HTTP Requests-------------------------------

    @PostMapping(value="/submitTransaction")
    public ResponseEntity submitTransaction(@RequestBody Transactions t){

        Transactions newTransaction = tDAO.save(t);


        if(newTransaction == null){
            return ResponseEntity.badRequest().build(); //send a 400 status code, and no response body
        }

        //if insert succeeded...
        return ResponseEntity.accepted().body(newTransaction); //send a 202 status code and the new digimon
    }

    @GetMapping (value="/getAllTransactions")
    //url: localhost:5556/data/accounts/getAllAccounts
    public ResponseEntity<List<Transactions>> getAllAccounts(){

        return ResponseEntity.ok(tDAO.findAll()); //.ok() returns a 200 level status code


    }

    @GetMapping (value="/getAllTransactionType")
    //url: localhost:5556/data/transactions/getAllTransactionType?accountIdTransaction=1&transactionType=expense
    //url: localhost:5556/data/transactions/getAllTransactionType?accountIdTransaction=1&transactionType=income
    public ResponseEntity<List<Transactions>> getByAcctIdAndTransactionType(@RequestParam int accountIdTransaction, @RequestParam String transactionType){

        Optional<List<Transactions>> transactionOptional = tDAO.getByAccountIdTransactionAndTransactionType(accountIdTransaction, transactionType );

        if(transactionOptional.isPresent()){

            List<Transactions> extractedTransaction = transactionOptional.get();

            return ResponseEntity.ok(extractedTransaction);
        }

        return ResponseEntity.badRequest().build();

    }


}


