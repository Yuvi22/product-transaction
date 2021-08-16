package com.assignment.producttransaction.mapper;

import com.assignment.producttransaction.entity.Category;
import com.assignment.producttransaction.models.Request.CategoryRequest;
import com.assignment.producttransaction.models.Response.CategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author yuvi
 */
@Mapper(componentModel = "spring")
public interface CategoryMapper {


    @Mapping(target = "categoryId", ignore = true)
    Category mapCategoryRequestToEntity(CategoryRequest request);

    CategoryResponse mapEntityToResponse(Category entity);

}
