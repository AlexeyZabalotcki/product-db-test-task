package com.example.productdbtesttask.service;

import com.example.productdbtesttask.dao.SupplierRepository;
import com.example.productdbtesttask.entity.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public Supplier findById(int id) {
        Optional<Supplier> result = supplierRepository.findById(id);

        Supplier supplier = null;

        if (result.isPresent()) {
            supplier = result.get();
        } else {
            throw new RuntimeException("There are no such supplier with id - " + id);
        }

        return supplier;
    }

    public void remove(int id) {
        supplierRepository.deleteById(id);
    }

    public void saveOrUpdate(Supplier supplier) {
        supplierRepository.save(supplier);
    }


    @Override
    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }
}
