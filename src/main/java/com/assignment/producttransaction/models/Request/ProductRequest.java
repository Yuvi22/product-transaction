package com.assignment.producttransaction.models.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * @author yuvi
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {


    private Integer productId;

    @NotBlank(message = "Product name required")
    @Pattern(regexp = "^[A-Za-z0-9'À-Ÿá-ÿ \\-@&()_!.,]*$", message = "Invalid character entered!")
    @Size(max = 200, message = "Product name cannot be more than 200 characters")
    private String productName;

    @NotBlank(message = "Product description required")
    @Pattern(regexp = "^[A-Za-z0-9'À-Ÿá-ÿ \\-@&()_!.,]*$", message = "Invalid character entered!")
    @Size(max = 200, message = "Product description cannot be more than 200 characters!")
    private String productDesc;

    @Pattern(regexp = "^[0-9]*$", message = "Invalid character entered! only Integer allowed")
    @NotNull(message = "Category cannot be null")
    private Integer categoryId;

    @Pattern(regexp = "^[0-9]*$", message = "Invalid character entered! only Integer allowed")
    private Integer quantity;

    private BigDecimal unitPrice;
}
