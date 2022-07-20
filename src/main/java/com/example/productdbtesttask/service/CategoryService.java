package com.example.productdbtesttask.service;


import com.example.productdbtesttask.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();


    Category findById(int id);

    void remove(int id);

    void saveOrUpdate(Category category);
}
