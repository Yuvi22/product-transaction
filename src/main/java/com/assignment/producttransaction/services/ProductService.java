package com.assignment.producttransaction.services;

import com.assignment.producttransaction.models.Request.ProductRequest;
import com.assignment.producttransaction.models.Response.ProductResponse;

import java.util.List;

/**
 * @author yuvi
 */
public interface ProductService {

    /**
     * Method to save categories
     *
     * @param ProductRequests list of {@link ProductRequest}
     * @return list of {@link ProductResponse}
     */
    List<ProductResponse> saveProduct(List<ProductRequest> ProductRequests);

    /**
     * @param request {@link ProductRequest}
     */
    ProductResponse updateProduct(ProductRequest request);

    /**
     * Method to get Product
     *
     * @param productId
     * @return the name of the deleted product
     */
    ProductResponse getProductById(Integer productId);

    /**
     * Method to delete Product
     *
     * @param productId
     * @return the name of the deleted product
     */
    void deleteProduct(Integer productId);

    /**
     * Method to get all Product
     *
     * @return list of {@link ProductResponse}
     */
    List<ProductResponse> searchProduct(ProductRequest productRequest);
}
