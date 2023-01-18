package com.revature.exception;

public class OverDraftException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public OverDraftException() {
        super("You cannot withdraw more money than you have in your account.");
    }

}