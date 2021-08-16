package com.assignment.producttransaction.controller;

import com.assignment.producttransaction.models.Request.CategoryRequest;
import com.assignment.producttransaction.models.Response.CategoryResponse;
import com.assignment.producttransaction.services.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author yuvi
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@Validated
@RequestMapping("/category")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoryController {


    private final CategoryService categoryService;

    /**
     * Method to add categories
     *
     * @param categoryRequests {@link CategoryRequest}
     * @return list of {@link CategoryResponse}
     */
    @PostMapping("/addCategories")
    private List<CategoryResponse> addCategories(@RequestBody @Valid List<CategoryRequest> categoryRequests) {
        return categoryService.saveCategories(categoryRequests);
    }

    /**
     * Method to update a category
     *
     * @param categoryRequests {@link CategoryRequest}
     */
    @PutMapping("/updateCategory")
    private void updateCategory(@Valid @RequestBody CategoryRequest categoryRequests) {
        categoryService.updateCategory(categoryRequests);
    }

    /**
     * Method to update a category
     *
     * @param categoryRequests {@link CategoryRequest}
     */
    @PutMapping("/categoryActiveStatusUpdate")
    private void categoryActiveStatusUpdate(@RequestParam @NotNull(message = "id cannot be null") Integer categoryId, boolean active) {
        categoryService.categoryActiveStatusUpdate(categoryId, active);
    }

    /**
     * Method to get category by id
     *
     * @param categoryId the categoryId
     * @return {@link CategoryResponse}
     */
    @GetMapping("/getCategoryById")
    private CategoryResponse getCategoryById(@RequestParam @NotNull(message = "id cannot be null") Integer categoryId) {
        return categoryService.getCategoryById(categoryId);
    }

    /**
     * Method to get category by id
     *
     * @param categoryId the categoryId
     * @return {@link CategoryResponse}
     */
    @DeleteMapping("/deleteCategory")
    private void deleteCategory(@RequestParam @NotNull(message = "id cannot be null") Integer categoryId) {
        categoryService.deleteCategory(categoryId);
    }

    /**
     * Method to get all categories
     *
     * @return list of {@link CategoryResponse}
     */
    @GetMapping("/getAllCategories")
    private List<CategoryResponse> getAllCategories() {
        return categoryService.getAllCategories();
    }
}
