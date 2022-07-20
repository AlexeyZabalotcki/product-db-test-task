package com.example.productdbtesttask.service;

import com.example.productdbtesttask.dao.CategoryRepository;
import com.example.productdbtesttask.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(int id) {
        Optional<Category> result = categoryRepository.findById(id);

        Category category = null;

        if (result.isPresent()) {
            category = result.get();
        } else {
            throw new RuntimeException("There are no such category with id - " + id);
        }

        return category;
    }

    public void remove(int id) {
        categoryRepository.deleteById(id);
    }

    public void saveOrUpdate(Category category) {
        categoryRepository.save(category);
    }
}
