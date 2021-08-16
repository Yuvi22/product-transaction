package com.assignment.producttransaction.mapper;

import com.assignment.producttransaction.entity.Category;
import com.assignment.producttransaction.models.Request.CategoryRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * @author yuvi
 */
@SpringBootTest("ProductTransactionApplication.class")
@ActiveProfiles("test")
class CategoryMapperTest {

    @Autowired
    CategoryMapper mapper;

    @Test
    void mapCategoryRequestToEntity() {
        CategoryRequest categoryRequest = CategoryRequest.builder()
                .id(1)
                .categoryName("test")
                .active(true)
                .build();

        Category category = mapper.mapCategoryRequestToEntity(categoryRequest);

        Assertions.assertNotNull(categoryRequest);
        Assertions.assertNotNull(category);
    }

    @Test
    void mapEntityToResponse() {
    }
}