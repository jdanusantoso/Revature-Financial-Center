package com.revature.exception;

import com.revature.daos.UserDAO;

public class UserDoesNotExistException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public UserDoesNotExistException() {
        super("You are trying to login with a username and a password that does not exist.");
    }

}