package com.assignment.producttransaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.assignment.producttransaction.*"})
@EnableAutoConfiguration
public class ProductTransactionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductTransactionApplication.class, args);
    }

}
