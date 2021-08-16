package com.assignment.producttransaction.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author yuvi
 */
public class TestUtils {

    public static String jsonString(Object o) {
        try {
            return new ObjectMapper().writeValueAsString(o);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
