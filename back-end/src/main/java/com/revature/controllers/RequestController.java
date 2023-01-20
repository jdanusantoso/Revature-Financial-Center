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

    private final RequestsDAO rDAO;

    @Autowired
    public RequestController(RequestsDAO rDAO) {
        super();
        this.rDAO = rDAO;
    }

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
