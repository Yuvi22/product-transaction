package com.assignment.producttransaction.services.impl;

import com.assignment.producttransaction.entity.Product;
import com.assignment.producttransaction.exception.CategoryNotFoundException;
import com.assignment.producttransaction.exception.EmptyProductException;
import com.assignment.producttransaction.exception.ProductNotFoundException;
import com.assignment.producttransaction.mapper.ProductMapper;
import com.assignment.producttransaction.models.Request.ProductRequest;
import com.assignment.producttransaction.models.Response.ProductResponse;
import com.assignment.producttransaction.repository.CategoryRepository;
import com.assignment.producttransaction.repository.ProductRepository;
import com.assignment.producttransaction.services.Predicate.PredicateBuilder;
import com.assignment.producttransaction.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * @author yuvi
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;
    private final CategoryRepository categoryRepository;
    private final PredicateBuilder predicateBuilder;

    @Override
    public List<ProductResponse> saveProduct(List<ProductRequest> productRequests) {
        if (productRequests.isEmpty()) {
            throw new EmptyProductException("Product is empty");
        }
        List<Product> productList = new ArrayList<>();
        productRequests.forEach(
                request -> {
                    if (categoryRepository.existsById(request.getCategoryId())) {
                        productList.add(mapper.mapProductRequestToEntity(request));
                    } else {
                        throw new CategoryNotFoundException("Category does not exist");
                    }

                }
        );
        repository.saveAll(productList);
        return productList.stream().map(mapper::mapEntityToResponse).collect(Collectors.toList());
    }

    @Override
    public ProductResponse updateProduct(ProductRequest request) {
        AtomicReference<Product> productUpdated = new AtomicReference<>();
        repository.findById(request.getProductId()).ifPresentOrElse(
                product -> {
                    if (categoryRepository.existsById(request.getCategoryId())) {
                        productUpdated.set(mapper.mapProductRequestToEntity(request));
                        repository.save(productUpdated.get());
                    } else {
                        throw new CategoryNotFoundException("Category does not exist");
                    }

                }, () -> {
                    throw new ProductNotFoundException("Product not found");
                });
        return mapper.mapEntityToResponse(productUpdated.get());
    }

    @Override
    public ProductResponse getProductById(Integer productId) {
        Product product = repository.findById(productId).orElseThrow(() -> {
            throw new ProductNotFoundException("Product not found");
        });
        return mapper.mapEntityToResponse(product);
    }

    @Override
    public void deleteProduct(Integer productId) {
        repository.findById(productId).ifPresentOrElse(category ->
                        repository.deleteById(productId),
                () -> {
                    throw new ProductNotFoundException("Product not found");
                });
    }

    @Override
    public List<ProductResponse> searchProduct(ProductRequest productRequest) {
        PageRequest pageRequest = PageRequest.of(0, Integer.MAX_VALUE, Sort.Direction.ASC, "productName");
        List<Product> productList = repository.findAll(predicateBuilder.builderFilterForReporting(productRequest), pageRequest).getContent();
        return productList.stream().map(mapper::mapEntityToResponse).collect(Collectors.toList());
    }
}
