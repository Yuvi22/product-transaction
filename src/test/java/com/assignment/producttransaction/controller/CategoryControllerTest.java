package com.assignment.producttransaction.controller;

import com.assignment.producttransaction.models.Request.CategoryRequest;
import com.assignment.producttransaction.services.CategoryService;
import com.assignment.producttransaction.utils.TestUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author yuvi
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {CategoryController.class})
class CategoryControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CategoryService categoryService;

    @Test
    @DisplayName("Method to test add categories")
    void addCategories() throws Exception {
        List<String> categories = List.of("test1", "test2");
        mockMvc.perform(MockMvcRequestBuilders.post("/category/addCategories")
                        .content(TestUtils.jsonString(categories))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void updateCategory() throws Exception {
        CategoryRequest categoryRequest = CategoryRequest.builder()
                .id(1)
                .categoryName("test")
                .active(true)
                .build();
        mockMvc.perform(MockMvcRequestBuilders.put("/category/addCategories")
                        .content(TestUtils.jsonString(categoryRequest))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getCategoryById() {
    }

    @Test
    void deleteCategory() {
    }

    @Test
    void getAllCategories() {
    }
}