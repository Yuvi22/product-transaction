package com.assignment.producttransaction.services.impl;

import com.assignment.producttransaction.entity.Category;
import com.assignment.producttransaction.exception.CategoryFoundException;
import com.assignment.producttransaction.exception.CategoryNotFoundException;
import com.assignment.producttransaction.exception.EmptyCategoryException;
import com.assignment.producttransaction.mapper.CategoryMapper;
import com.assignment.producttransaction.models.Request.CategoryRequest;
import com.assignment.producttransaction.models.Response.CategoryResponse;
import com.assignment.producttransaction.repository.CategoryRepository;
import com.assignment.producttransaction.repository.ProductRepository;
import com.assignment.producttransaction.services.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yuvi
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {


    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final CategoryMapper mapper;

    @Override
    public List<CategoryResponse> saveCategories(List<CategoryRequest> categoryRequests) {

        if (categoryRequests.isEmpty()) {
            throw new EmptyCategoryException("Category is emppty");
        }
        List<Category> categoryList = new ArrayList<>();
        categoryRequests.forEach(
                request -> categoryList.add(mapper.mapCategoryRequestToEntity(request))
        );
        categoryRepository.saveAll(categoryList);
        return categoryList.stream().map(mapper::mapEntityToResponse).collect(Collectors.toList());
    }

    @Override
    public void updateCategory(CategoryRequest request) {

        categoryRepository.findById(request.getId()).ifPresentOrElse(
                categoryFound -> {
                    categoryFound.setCategoryName(request.getCategoryName());
                    categoryRepository.save(categoryFound);
                }, () -> {
                    throw new CategoryNotFoundException("Category Not Found");
                });
    }

    public void categoryActiveStatusUpdate(Integer categoryId, boolean active) {
        categoryRepository.findById(categoryId).ifPresentOrElse(
                categoryFound -> {
                    categoryFound.setActive(active);
                    categoryRepository.save(categoryFound);
                }, () -> {
                    throw new CategoryNotFoundException("Category Not Found");
                });
    }

    @Override
    public CategoryResponse getCategoryById(Integer categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> {
            throw new CategoryNotFoundException("");
        });
        return mapper.mapEntityToResponse(category);
    }

    @Override
    public void deleteCategory(Integer categoryId) {

        categoryRepository.findById(categoryId).ifPresentOrElse(category -> {
                    if (!productRepository.existsByCategoryId(categoryId)) {
                        categoryRepository.deleteById(categoryId);
                    } else {
                        throw new CategoryFoundException("Category Exist in product");
                    }
                },
                () -> {
                    throw new CategoryNotFoundException("Category Not Found");
                });
    }

    @Override
    public List<CategoryResponse> getAllCategories() {

        List<Category> categoryList = categoryRepository.findAll();
        if (categoryList.isEmpty()) {
            throw new CategoryNotFoundException("Category Not Found");
        }
        return categoryList.stream().map(mapper::mapEntityToResponse).collect(Collectors.toList());
    }

}
