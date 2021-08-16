package com.assignment.producttransaction.services.Predicate;

import com.assignment.producttransaction.entity.QProduct;
import com.assignment.producttransaction.models.Request.ProductRequest;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Predicate builder for product
 *
 * @author yuvi
 */
@Slf4j
@Component
public class PredicateBuilder {

    public BooleanBuilder builderFilterForReporting(ProductRequest request) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();

        List<Predicate> predicates = new ArrayList<>();

        if (request == null) {
            return booleanBuilder;
        }

        if (StringUtils.hasText(request.getProductName())) {
            predicates.add(QProduct.product.productName.containsIgnoreCase(request.getProductName()));
        }

        if (StringUtils.hasText(request.getProductDesc())) {
            predicates.add(QProduct.product.productDesc.containsIgnoreCase(request.getProductDesc()));
        }

        if (request.getQuantity() != null) {
            predicates.add(QProduct.product.quantity.eq(request.getQuantity()));
        }

        if (request.getUnitPrice() != null) {
            predicates.add(QProduct.product.unitPrice.eq(request.getUnitPrice()));
        }

        if (!predicates.isEmpty()) {
            booleanBuilder.orAllOf(predicates.toArray(new Predicate[0]));
        }
        return booleanBuilder;
    }
}
