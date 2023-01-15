package com.revature.controllers;

import com.revature.daos.AccountsDAO;
import com.revature.models.Accounts;
import com.revature.models.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    //GET all digimon - any GET requests to /digimon will go here
    @GetMapping (value="/getAllAccounts")
    public ResponseEntity<List<Accounts>> getAllAccounts(){

        return ResponseEntity.ok(aDAO.findAll()); //.ok() returns a 200 level status code

        //note that I'm nesting the DB call in the actual return
        //this is shorthand - I could have done .ok().body(dDAO.findAll());

    }

    @GetMapping(value="/id/{id}")
    public ResponseEntity<Accounts> findById(@PathVariable int id){

        /* findById from JpaRepository returns an Optional
          Optionals lend to code flexibility because it MAY OR MAY NOT have the request object.
          This helps us avoid NullPointerExceptions
         */
        Optional<Accounts> accountOptional = aDAO.findById(id);

        //we can check if the optional has data with .isPresent(), or .isEmpty()
        if(accountOptional.isPresent()){
            //we can extract the Optional's data with .get()
            Accounts extractedAccount = accountOptional.get();

            return ResponseEntity.ok(extractedAccount);
        }
        //if get by ID failed...
        return ResponseEntity.badRequest().build(); //returning a 400 with no response body
    }

    @GetMapping(value="/accountHolder/{accountHolder}")
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


}
