package com.revature.controllers;

import com.revature.daos.RequestsDAO;
import com.revature.models.Requests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //This combines @Controller and @ResponseBody
@CrossOrigin //lets us take in HTTP requests (might have to specify ports in your P2)
@RequestMapping(value="/requests")
public class RequestController {

<<<<<<< HEAD
    //autowiring the DigimonDAO with constructor injection

=======
>>>>>>> d2cbae9348d9fc90c0d94fedc0bbdbc59b42c7ce
    private final RequestsDAO rDAO;

    @Autowired
    public RequestController(RequestsDAO rDAO) {
        super();
        this.rDAO = rDAO;
    }


    //HTTP Requests-------------------------------

<<<<<<< HEAD
    //insert digimon - every POST request to /digimon will go here
=======
>>>>>>> d2cbae9348d9fc90c0d94fedc0bbdbc59b42c7ce
    @PostMapping(value="/newRequest")
    //url : localhost:5556/data/accounts/new
    public ResponseEntity addAccount(@RequestBody Requests r){

        Requests newRequest = rDAO.save(r);


        if(newRequest == null){
            return ResponseEntity.badRequest().build(); //send a 400 status code, and no response body
        }

        return ResponseEntity.accepted().body(newRequest); //send a 202 status code and the new digimon
    }



}
