package com.assignment.producttransaction.models.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Class representing product response
 *
 * @author yuvi
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

    private Integer productId;

    private String productName;

    private String productDesc;

    private Integer categoryId;

    private Integer quantity;

    private BigDecimal unitPrice;

    private boolean active;
}
