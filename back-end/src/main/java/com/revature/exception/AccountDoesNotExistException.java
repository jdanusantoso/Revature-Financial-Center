package com.revature.exception;

public class AccountDoesNotExistException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public AccountDoesNotExistException() {
        super("You are searching for a bank account that does not exist.");
    }

}