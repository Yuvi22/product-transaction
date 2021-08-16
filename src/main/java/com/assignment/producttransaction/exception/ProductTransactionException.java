package com.assignment.producttransaction.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * @author yuvi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductTransactionException {

    private HttpStatus status;
    private String message;


}
