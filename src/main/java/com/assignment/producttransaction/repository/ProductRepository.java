package com.assignment.producttransaction.repository;

import com.assignment.producttransaction.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * @author yuvi
 */
public interface ProductRepository extends JpaRepository<Product, Integer>, QuerydslPredicateExecutor<Product> {

    boolean existsByCategoryId(Integer categoryId);
}
