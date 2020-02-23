package com.javadevjournal.exception;

public class FileStorageException extends Exception {

    public FileStorageException() {
        super();
    }

    public FileStorageException(String message) {
        super(message);
    }

    public FileStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
