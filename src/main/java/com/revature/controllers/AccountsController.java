package com.revature.controllers;

import com.revature.daos.AccountsDAO;
import com.revature.models.Accounts;
import com.revature.models.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //This combines @Controller and @ResponseBody
@CrossOrigin //lets us take in HTTP requests (might have to specify ports in your P2)
@RequestMapping(value="/accounts")
public class AccountsController {

    //autowiring the DigimonDAO with constructor injection

    private final AccountsDAO aDAO;

    @Autowired
    public AccountsController(AccountsDAO aDAO) {
        super();
        this.aDAO = aDAO;
    }

    //HTTP Requests-------------------------------

    //insert digimon - every POST request to /digimon will go here
    @PostMapping(value="/new")
    public ResponseEntity addDigimon(@RequestBody Accounts a){

        //Thanks to @RequestBody, our Digimon d parameter is filled with the body of the HTTP Request
        //Automatic JSON conversion :)

        //the save() method from our DAO is how we can insert new data
        Accounts newAccount = aDAO.save(a);

        //if insert failed...
        if(newAccount == null){
            return ResponseEntity.badRequest().build(); //send a 400 status code, and no response body
        }

        //if insert succeeded...
        return ResponseEntity.accepted().body(newAccount); //send a 202 status code and the new digimon
    }


}
