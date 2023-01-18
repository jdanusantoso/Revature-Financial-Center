package com.revature.exception;

public class InvalidAccountTransferException extends RuntimeException{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public InvalidAccountTransferException() {
        super("You cannot transfer to the same account. Please enter a different account.");
    }

}
