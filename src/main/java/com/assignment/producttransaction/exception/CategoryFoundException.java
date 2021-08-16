package com.assignment.producttransaction.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author yuvi
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CategoryFoundException extends RuntimeException {
    public CategoryFoundException(String message) {
        super(message);
    }
}
