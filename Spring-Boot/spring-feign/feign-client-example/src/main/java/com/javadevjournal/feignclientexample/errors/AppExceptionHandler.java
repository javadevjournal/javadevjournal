package com.javadevjournal.feignclientexample.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<?> handleException(ProductNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(exception.getMessage());
    }

}
