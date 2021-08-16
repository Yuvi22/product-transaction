package com.assignment.producttransaction.models.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author yuvi
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Valid
public class CategoryRequest {

    private Integer id;

    @NotBlank(message = "Category required")
    @Pattern(regexp = "^[A-Za-z0-9'À-Ÿá-ÿ \\-@&()_!.,]*$", message = "Invalid character entered!")
    @Size(max = 200, message = "Product name cannot be more than 200 characters")
    private String categoryName;

    @NotNull(message = "Active status cannot be null")
    private boolean active = true;
}
