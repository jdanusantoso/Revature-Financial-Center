package com.revature.exception;

public class UserNotFoundException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public UserNotFoundException() {
        super("The user you are searching for does not exist.");
    }

}