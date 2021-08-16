package com.assignment.producttransaction.entity;

import com.assignment.producttransaction.entity.shared.AbstractEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * @author yuvi
 */
@Entity
@Table(name = "PRODUCT_REFERENCE")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product extends AbstractEntity {

    @Id
    @Column(name = "PRODUCT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column(name = "PRODUCT_NAME")
    @NotBlank(message = "Product name required")
    @Pattern(regexp = "^[A-Za-z0-9'À-Ÿá-ÿ \\-@&()_!.,]*$", message = "Invalid character entered!")
    @Size(max = 200, message = "Product name cannot be more than 200 characters")
    private String productName;

    @Column(name = "PRODUCT_DESC")
    @NotBlank(message = "Product description required")
    @Pattern(regexp = "^[A-Za-z0-9'À-Ÿá-ÿ \\-@&()_!.,]*$", message = "Invalid character entered!")
    @Size(max = 200, message = "Product description cannot be more than 200 characters!")
    private String productDesc;

    @Column(name = "CATEGORY_ID")
    @NotNull(message = "Category cannot be null")
    private Integer categoryId;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "UNIT_PRICE")
    private BigDecimal unitPrice;

    @Column(name = "ACTIVE")
    private boolean active;
}
