package com.revature.controllers;

import com.revature.daos.AccountsDAO;
import com.revature.daos.TransactionsDAO;
import com.revature.models.Accounts;
import com.revature.models.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //This combines @Controller and @ResponseBody
@CrossOrigin //lets us take in HTTP requests (might have to specify ports in your P2)
@RequestMapping(value="/transactions")
public class TransactionsController {

    //autowiring the DigimonDAO with constructor injection

    private final TransactionsDAO tDAO;

    @Autowired
    public TransactionsController(TransactionsDAO tDAO) {
        super();
        this.tDAO = tDAO;
    }

    //HTTP Requests-------------------------------

    //insert digimon - every POST request to /digimon will go here

    @PostMapping(value="/submitTransaction")
    //url: localhost:5556/data/transactions/submitTransaction
    public ResponseEntity submitTransaction(@RequestBody Transactions t){

        //Thanks to @RequestBody, our Digimon d parameter is filled with the body of the HTTP Request
        //Automatic JSON conversion :)

        //the save() method from our DAO is how we can insert new data
        Transactions newTransaction = tDAO.save(t);

        //if insert failed...
        if(newTransaction == null){
            return ResponseEntity.badRequest().build(); //send a 400 status code, and no response body
        }

        //if insert succeeded...
        return ResponseEntity.accepted().body(newTransaction); //send a 202 status code and the new digimon
    }

    @GetMapping (value="/getAllTransactions")
    //url: localhost:5556/data/transactions/getAllTransactions
    public ResponseEntity<List<Transactions>> getAllTransactions(){

        return ResponseEntity.ok(tDAO.findAll()); //.ok() returns a 200 level status code

        //note that I'm nesting the DB call in the actual return
        //this is shorthand - I could have done .ok().body(dDAO.findAll());

    }

    @GetMapping (value="/getAllTransactionType")
    //url: localhost:5556/data/transactions/getAllTransactionType?accountIdTransaction=1&transactionType=expense
    //url: localhost:5556/data/transactions/getAllTransactionType?accountIdTransaction=1&transactionType=income
    public ResponseEntity<List<Transactions>> getByAcctIdAndTransactionType(@RequestParam int accountIdTransaction, @RequestParam String transactionType){

        Optional<List<Transactions>> transactionOptional = tDAO.getByAccountIdTransactionAndTransactionType(accountIdTransaction, transactionType );

        //we can check if the optional has data with .isPresent(), or .isEmpty()
        if(transactionOptional.isPresent()){
            //we can extract the Optional's data with .get()
            List<Transactions> extractedTransaction = transactionOptional.get();

            return ResponseEntity.ok(extractedTransaction);
        }
        //if get by name failed...
        return ResponseEntity.badRequest().build(); //returning a 400 with no response body

    }




}
