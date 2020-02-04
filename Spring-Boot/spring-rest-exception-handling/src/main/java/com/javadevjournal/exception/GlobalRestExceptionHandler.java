package com.javadevjournal.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;


@ControllerAdvice
public class GlobalRestExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler({CustomerNotFoundException.class})
    public ResponseEntity<ApiErrorResponse> customerNotFound(CustomerNotFoundException ex, WebRequest request){
        ApiErrorResponse apiResponse =new ApiErrorResponse
                                 .ApiErrorResponseBuilder()
                                .withDetail("Not able to find customer record")
                                .withMessage("Not a valid user id.Please provide a valid user id or contact system admin.")
                                .withError_code("404")
                                .withStatus(HttpStatus.NOT_FOUND)
                                .atTime(LocalDateTime.now(ZoneOffset.UTC))
                                .build();
        return new ResponseEntity<ApiErrorResponse>(apiResponse, HttpStatus.NOT_FOUND);

        //We can define other handlers based on Exception types
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){

        // let's get all validation error and send it across
        List<String> errorMsg= ex.getBindingResult().getFieldErrors().stream().map(e->e.getDefaultMessage()).collect(Collectors.toList());
        ApiErrorResponse response =new ApiErrorResponse.ApiErrorResponseBuilder()
                .withStatus(status)
                .withDetail("not valid arguments")
                .withMessage(errorMsg.toString())
                .withError_code("406")
                .withError_code(status.NOT_ACCEPTABLE.name())
                .atTime(LocalDateTime.now(ZoneOffset.UTC))
                .build();
        return new ResponseEntity<>(response, response.getStatus());
    }

    @ExceptionHandler(CustomRestServiceException.class)
    protected ResponseEntity<Object> handleCustomAPIException(CustomRestServiceException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        ApiErrorResponse response =new ApiErrorResponse.ApiErrorResponseBuilder()
                .withStatus(status)
                .withDetail("custom exception")
                .withMessage(ex.getLocalizedMessage())
                .withError_code("503")
                .withError_code(status.SERVICE_UNAVAILABLE.name())
                .atTime(LocalDateTime.now(ZoneOffset.UTC))
                .build();
        return new ResponseEntity<>(response, response.getStatus());
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleCustomAPIException(Exception ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        ApiErrorResponse response =new ApiErrorResponse.ApiErrorResponseBuilder()
                .withStatus(status)
                .withDetail("Something went wrong")
                .withMessage(ex.getLocalizedMessage())
                .withError_code("502")
                .withError_code(status.BAD_GATEWAY.name())
                .atTime(LocalDateTime.now(ZoneOffset.UTC))
                .build();
        return new ResponseEntity<>(response, response.getStatus());
    }

    // to handle JSR303 error.

}
