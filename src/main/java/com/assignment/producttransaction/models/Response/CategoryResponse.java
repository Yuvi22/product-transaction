package com.assignment.producttransaction.models.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class representing category response
 *
 * @author yuvi
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {

    private String categoryName;

    private boolean active;
}
