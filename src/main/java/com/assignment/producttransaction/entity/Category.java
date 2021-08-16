package com.assignment.producttransaction.entity;


import com.assignment.producttransaction.entity.shared.AbstractEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author yuvi
 */
@Entity
@Table(name = "CATEGORIES")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category extends AbstractEntity {

    @Id
    @Column(name = "CATEGORY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    @Column(name = "CATEGORY_NAME")
    @NotBlank(message = "Category required")
    @Pattern(regexp = "^[A-Za-z0-9'À-Ÿá-ÿ \\-@&()_!.,]*$", message = "Invalid character entered!")
    @Size(max = 200, message = "Product name cannot be more than 200 characters")
    private String categoryName;

    @Column(name = "ACTIVE")
    private boolean active;
}
