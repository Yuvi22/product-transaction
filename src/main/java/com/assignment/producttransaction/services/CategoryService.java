package com.assignment.producttransaction.services;

import com.assignment.producttransaction.models.Request.CategoryRequest;
import com.assignment.producttransaction.models.Response.CategoryResponse;

import java.util.List;

/**
 * @author yuvi
 */
public interface CategoryService {

    /**
     * Method to save categories
     *
     * @param categoryRequests list of {@link CategoryRequest}
     * @return list of {@link CategoryResponse}
     */
    List<CategoryResponse> saveCategories(List<CategoryRequest> categoryRequests);

    /**
     * @param request {@link CategoryRequest}
     */
    void updateCategory(CategoryRequest request);

    /**
     * Method to activate or deactivate a category
     *
     * @param categoryId the category id
     * @param active     the status
     */
    void categoryActiveStatusUpdate(Integer categoryId, boolean active);

    /**
     * Method to get categories
     *
     * @param categoryId
     * @return the name of the deleted product
     */
    CategoryResponse getCategoryById(Integer categoryId);

    /**
     * Method to delete categories
     *
     * @param categoryId
     * @return the name of the deleted product
     */
    void deleteCategory(Integer categoryId);

    /**
     * Method to get all categories
     *
     * @return list of {@link CategoryResponse}
     */
    List<CategoryResponse> getAllCategories();
}
