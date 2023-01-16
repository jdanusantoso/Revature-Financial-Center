package com.revature.controllers;

import com.revature.daos.AccountsDAO;
import com.revature.daos.TransactionsDAO;
import com.revature.models.Accounts;
import com.revature.models.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //This combines @Controller and @ResponseBody
@CrossOrigin //lets us take in HTTP requests (might have to specify ports in your P2)
@RequestMapping(value="/accounts")
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


}
