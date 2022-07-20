package com.example.productdbtesttask.dao;

import com.example.productdbtesttask.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}
