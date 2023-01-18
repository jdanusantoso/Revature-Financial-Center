package com.revature.exception;

public class InvalidAmountException extends RuntimeException{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public InvalidAmountException() {
        super("You cannot deposit an amount less than or equal to 0. Please input a valid number.");
    }


}
