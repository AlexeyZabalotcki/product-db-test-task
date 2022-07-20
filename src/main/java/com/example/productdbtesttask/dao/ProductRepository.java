package com.example.productdbtesttask.dao;


import com.example.productdbtesttask.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
