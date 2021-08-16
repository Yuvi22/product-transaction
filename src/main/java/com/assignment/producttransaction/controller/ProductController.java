package com.assignment.producttransaction.controller;

import com.assignment.producttransaction.models.Request.ProductRequest;
import com.assignment.producttransaction.models.Response.ProductResponse;
import com.assignment.producttransaction.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@Validated
@RequestMapping("/product")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {


    private final ProductService service;

    /**
     * API to add Products
     *
     * @param productRequests {@link ProductRequest}
     * @return list of {@link ProductResponse}
     */
    @PostMapping("/addProducts")
    private List<ProductResponse> addProducts(@RequestBody @Valid List<ProductRequest> productRequests) {
        return service.saveProduct(productRequests);
    }

    /**
     * API to update a Product
     *
     * @param productRequests {@link ProductRequest}
     */
    @PutMapping("/updateProduct")
    private ProductResponse updateProduct(@RequestBody @Valid ProductRequest productRequests) {

        return service.updateProduct(productRequests);
    }

    /**
     * API to get Product by id
     *
     * @param productId the product id
     */
    @GetMapping("/deleteProduct")
    private void deleteProduct(@RequestParam Integer productId) {
        service.deleteProduct(productId);
    }

    /**
     * API to get all Products
     *
     * @return list of {@link ProductResponse}
     */
    @GetMapping("/searchProduct")
    private List<ProductResponse> searchProduct(@Valid ProductRequest productRequest) {
        return service.searchProduct(productRequest);
    }
}
