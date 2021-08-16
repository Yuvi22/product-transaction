package com.assignment.producttransaction.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

/**
 * @author yuvi
 */
@RestControllerAdvice
public class RestExceptionHandler {

    private final String BAD_INPUT = "Wrong input";

    @ExceptionHandler(EmptyCategoryException.class)
    public ResponseEntity<Object> handlesEmptyCategoryException(EmptyCategoryException exception, WebRequest request) {
        ProductTransactionException productTransactionException = new ProductTransactionException(HttpStatus.BAD_REQUEST, exception.getMessage());
        return new ResponseEntity<>(exception, new HttpHeaders(), productTransactionException.getStatus());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handlesConstraintViolationExceptionn(ConstraintViolationException exception, WebRequest request) {

        String message = exception.getConstraintViolations().stream().findFirst().map(
                ConstraintViolation::getMessage
        ).orElse(BAD_INPUT);
        ProductTransactionException productTransactionException = new ProductTransactionException(HttpStatus.BAD_REQUEST, message);
        return new ResponseEntity<>(exception, new HttpHeaders(), productTransactionException.getStatus());
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<Object> handlesCategoryNotFoundException(CategoryNotFoundException exception, WebRequest request) {
        ProductTransactionException productTransactionException = new ProductTransactionException(HttpStatus.NOT_FOUND, exception.getMessage());
        return new ResponseEntity<>(exception, new HttpHeaders(), productTransactionException.getStatus());
    }
}
