package com.javadevjournal.core.exception;

public class InvalidTokenException extends Exception {

    public InvalidTokenException() {
        super();
    }


    public InvalidTokenException(String message) {
        super(message);
    }


    public InvalidTokenException(String message, Throwable cause) {
        super(message, cause);
    }
}
