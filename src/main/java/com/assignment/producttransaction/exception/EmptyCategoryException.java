package com.assignment.producttransaction.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom class for empty category
 *
 * @author yuvi
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmptyCategoryException extends RuntimeException {

    public EmptyCategoryException(String message) {
        super(message);
    }

}
