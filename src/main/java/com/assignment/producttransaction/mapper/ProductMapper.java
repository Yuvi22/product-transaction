package com.assignment.producttransaction.mapper;

import com.assignment.producttransaction.entity.Product;
import com.assignment.producttransaction.models.Request.ProductRequest;
import com.assignment.producttransaction.models.Response.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author yuvi
 */
@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "active", ignore = true)
    Product mapProductRequestToEntity(ProductRequest request);

    ProductResponse mapEntityToResponse(Product entity);


}
