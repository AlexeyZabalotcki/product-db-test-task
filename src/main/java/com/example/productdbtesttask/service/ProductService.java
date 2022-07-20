package com.example.productdbtesttask.service;


import com.example.productdbtesttask.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(int id);

    void remove(int id);

    void saveOrUpdate(Product product);

}
