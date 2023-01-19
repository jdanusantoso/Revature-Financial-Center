package com.revature.controllers;

import com.revature.daos.AccountsDAO;
import com.revature.exception.AccountDoesNotExistException;
import com.revature.exception.OverDraftException;
import com.revature.models.Accounts;
import com.revature.models.Transactions;
import com.revature.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Optional;

@RestController //This combines @Controller and @ResponseBody
@CrossOrigin //lets us take in HTTP requests (might have to specify ports in your P2)
@RequestMapping(value="/accounts")
public class AccountsController {


    private final AccountsDAO aDAO;

    @Autowired
    public AccountsController(AccountsDAO aDAO) {
        super();
        this.aDAO = aDAO;
    }

    @Autowired
    private AccountService accountService;

    //HTTP Requests-------------------------------


    @PostMapping(value="/new")
    //url : localhost:5556/data/accounts/new
    public ResponseEntity addAccount(@RequestBody Accounts a){


        Accounts newAccount = aDAO.save(a);

        //if insert failed...
        if(newAccount == null){
            return ResponseEntity.badRequest().build(); //send a 400 status code, and no response body
        }

        //if insert succeeded...
        return ResponseEntity.accepted().body(newAccount); //send a 202 status code and the new digimon
    }


    @GetMapping (value="/getAllAccounts")
    //url: localhost:5556/data/accounts/getAllAccounts
    public ResponseEntity<List<Accounts>> getAllAccounts(){

        return ResponseEntity.ok(aDAO.findAll()); //.ok() returns a 200 level status code


    }

    @GetMapping(value="/accountId/{accountId}")
    //url : localhost:5556/data/accounts/accountId/1
    public ResponseEntity<Accounts> findById(@PathVariable int accountId){


        Optional<Accounts> accountOptional = aDAO.findById(accountId);

        //we can check if the optional has data with .isPresent(), or .isEmpty()
        if(accountOptional.isPresent()){

            Accounts extractedAccount = accountOptional.get();

            return ResponseEntity.ok(extractedAccount);
        }
        //if get by ID failed...
        return ResponseEntity.badRequest().build(); //returning a 400 with no response body
    }

    @GetMapping(value="/accountIdRecipient/{accountIdRecipient}")
    //url : localhost:5556/data/accounts/accountId/1
    public ResponseEntity<Accounts> findByAccountIdRecipient(@PathVariable int accountIdRecipient){


        Optional<Accounts> accountRecipientOptional = aDAO.findById(accountIdRecipient);


        if(accountRecipientOptional.isPresent()){

            Accounts extractedAccount = accountRecipientOptional.get();

            return ResponseEntity.ok(extractedAccount);
        }
        //if get by ID failed...
        return ResponseEntity.badRequest().build(); //returning a 400 with no response body
    }



    @GetMapping(value="/accountHolder/{accountHolder}")
    // localhost:5556/data/accounts/accountHolder/someone's name
    public ResponseEntity<List<Accounts>> findByName(@PathVariable String accountHolder){

        Optional<List<Accounts>> accountOptional = aDAO.findByAccountHolder(accountHolder);

        //we can check if the optional has data with .isPresent(), or .isEmpty()
        if(accountOptional.isPresent()){
            //we can extract the Optional's data with .get()
            List<Accounts> extractedAccount = accountOptional.get();

            return ResponseEntity.ok(extractedAccount);
        }
        //if get by name failed...
        return ResponseEntity.badRequest().build(); //returning a 400 with no response body

    }

    @PatchMapping(value="/deposit/{accountId}/{transactionAmount}")
    //url: localhost:5556/data/accounts/deposit/1/25.69
    public ResponseEntity depositMoney(@PathVariable int accountId, @RequestBody Accounts a, @PathVariable double transactionAmount){

        Accounts updateAccountBalance = aDAO.findById(accountId)
                .orElseThrow(() -> new AccountDoesNotExistException());

        updateAccountBalance.setAccountBalance(updateAccountBalance.getAccountBalance() + transactionAmount);


        aDAO.save(updateAccountBalance);


        return ResponseEntity.ok(updateAccountBalance);

    }

    @PatchMapping(value="/withdraw/{accountId}/{transactionAmount}")
    //url: localhost:5556/data/accounts/withdraw/1/25.69
    public ResponseEntity<Accounts> withdrawMoney(@PathVariable int accountId, @RequestBody Accounts a, @PathVariable double transactionAmount){

        Accounts updateAccountBalance = aDAO.findById(accountId)
                .orElseThrow(() -> new AccountDoesNotExistException());

        updateAccountBalance.setAccountBalance(updateAccountBalance.getAccountBalance() - transactionAmount);

        aDAO.save(updateAccountBalance);

        return ResponseEntity.ok(updateAccountBalance);

    }


}
