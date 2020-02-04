package com.javadevjournal.exception;

public class CustomRestServiceException extends Exception  {

    public CustomRestServiceException() {
        super();
    }

    public CustomRestServiceException(String message) {
        super(message);
    }

    public CustomRestServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
