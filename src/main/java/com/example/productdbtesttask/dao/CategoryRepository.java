package com.example.productdbtesttask.dao;

import com.example.productdbtesttask.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
