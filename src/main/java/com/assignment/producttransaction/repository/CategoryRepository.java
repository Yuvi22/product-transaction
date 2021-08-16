package com.assignment.producttransaction.repository;

import com.assignment.producttransaction.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * @author yuvi
 */
public interface CategoryRepository extends JpaRepository<Category, Integer>, QuerydslPredicateExecutor<Category> {

    @Override
    boolean existsById(Integer categoryId);
}
