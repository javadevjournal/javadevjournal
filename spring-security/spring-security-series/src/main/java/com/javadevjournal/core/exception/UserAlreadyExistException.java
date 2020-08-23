package com.javadevjournal.core.exception;

/**
 * Exception thrown by system in case some one try to register with already exisiting email
 * id in the system.
 */
public class UserAlreadyExistException extends Exception {

    public UserAlreadyExistException() {
        super();
    }


    public UserAlreadyExistException(String message) {
        super(message);
    }


    public UserAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
