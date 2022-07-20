package com.example.productdbtesttask.service;


import com.example.productdbtesttask.entity.Supplier;

import java.util.List;

public interface SupplierService {
    List<Supplier> findAll();


    Supplier findById(int id);

    void remove(int id);

    void saveOrUpdate(Supplier supplier);
}
