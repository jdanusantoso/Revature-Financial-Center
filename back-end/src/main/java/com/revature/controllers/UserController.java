package com.revature.controllers;

import com.revature.daos.UserDAO;
import com.revature.exception.UserDoesNotExistException;
import com.revature.exception.UserNotFoundException;
import com.revature.models.Users;
import com.revature.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //This combines @Controller and @ResponseBody
@CrossOrigin //lets us take in HTTP requests (might have to specify ports in your P2)
@RequestMapping(value="/users")
public class UserController {

    private final UserDAO uDAO;

    @Autowired
    public UserController(UserDAO uDAO) {
        super();
        this.uDAO = uDAO;
    }

    @Autowired
    private UserService userService;


    //HTTP Requests-------------------------------


    @PostMapping(value = "/registerUser")
    //url : localhost:5556/data/registerUser
    public ResponseEntity addAccount(@RequestBody Users u) {

        Users newUser = uDAO.save(u);


        if (newUser == null) {
            return ResponseEntity.badRequest().build(); //send a 400 status code, and no response body
        }


        return ResponseEntity.accepted().body(newUser); //send a 202 status code and the new digimon
    }




    @GetMapping (value="/getAllUsers")
    //url: localhost:5556/data/users/getAllUsers
    public ResponseEntity<List<Users>> getAllAccounts(){

        return ResponseEntity.ok(uDAO.findAll()); //.ok() returns a 200 level status code


    }

    @GetMapping (value="/login")
    //url: localhost:5556/data/users/login
    public ResponseEntity<List<Users>> getByUsernameAndPassword(@RequestParam("username") String username, @RequestParam("password")String password){

        Optional<List<Users>> userOptional = userService.loginUser(username, password );

        if(userOptional.isPresent()){

            List<Users> extractedUser = userOptional.get();

            return ResponseEntity.ok(extractedUser);
        }

        return ResponseEntity.badRequest().build(); //returning a 400 with no response body

    }

    @GetMapping(value="/findById/{userId}")
    //url : localhost:5556/data/accounts/id/1
    public ResponseEntity<Users> findById(@PathVariable int userId){

        Optional<Users> accountOptional = uDAO.findById(userId);

        //we can check if the optional has data with .isPresent(), or .isEmpty()
        if(accountOptional.isPresent()){
            //we can extract the Optional's data with .get()
            Users extractedUser = accountOptional.get();

            return ResponseEntity.ok(extractedUser);
        }
        //if get by ID failed...
        return ResponseEntity.badRequest().build(); //returning a 400 with no response body


    }

    @PatchMapping(value="/a/{userId}")
    public ResponseEntity<Users> updateUserInfo(@PathVariable int userId, @RequestBody Users user){
        Users updateUserInfo = uDAO.findById(userId)
                .orElseThrow(() -> new UserNotFoundException());

        updateUserInfo.setLastName(user.getLastName());
        updateUserInfo.setEmail(user.getEmail());
//        updateUser.setUsername(user.getUsername());
//        updateUser.setPassword(user.getPassword());

        uDAO.save(updateUserInfo);

        return ResponseEntity.ok(updateUserInfo);

    }

    @PatchMapping(value="/updateUserPassword/{userId}")
    public ResponseEntity<Users> updateUserPassword(@PathVariable int userId, @RequestBody Users user){
        Users updateUserPassword = uDAO.findById(userId)
                .orElseThrow(() -> new UserNotFoundException());

        updateUserPassword.setPassword(user.getPassword());

        uDAO.save(updateUserPassword);

        return ResponseEntity.ok(updateUserPassword);

    }


}

