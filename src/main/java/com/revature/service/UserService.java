package com.revature.service;

import com.revature.daos.UserDAO;
import com.revature.exception.UserDoesNotExistException;
import com.revature.models.Users;

import java.util.List;
import java.util.Optional;

public class UserService {

    private UserDAO userDao;
    private AccountService accountService;

    public UserService(UserDAO userDao, AccountService accountService) {
        this.userDao = userDao;
        this.accountService = accountService;
    }

    public Optional<List<Users>> loginUser(String username, String password) throws UserDoesNotExistException {
        Optional<List<Users>> u= userDao.getByUsernameAndPassword(username, password);

        if(u == null) {
            //This could also for example be InvalidCredentialsException in your project
            throw new UserDoesNotExistException();
        }

        return u;
    }

}
