package com.revature.service;

import com.revature.daos.UserDAO;
import com.revature.exception.UserDoesNotExistException;
import com.revature.models.Users;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserDAO userDao;

    public UserService(UserDAO userDao) {
        this.userDao = userDao;

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
