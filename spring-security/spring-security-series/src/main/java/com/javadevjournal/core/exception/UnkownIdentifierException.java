package com.javadevjournal.core.exception;

/*
In case customer account does not exists in the system for a given email id.
 */
public class UnkownIdentifierException extends Exception {

    public UnkownIdentifierException() {
        super();
    }


    public UnkownIdentifierException(String message) {
        super(message);
    }


    public UnkownIdentifierException(String message, Throwable cause) {
        super(message, cause);
    }
}
