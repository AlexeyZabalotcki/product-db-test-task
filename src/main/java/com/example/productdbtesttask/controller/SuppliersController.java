package com.example.productdbtesttask.controller;

import com.example.productdbtesttask.entity.Supplier;
import com.example.productdbtesttask.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/suppliers")
@Secured("ROLE_ADMIN")
public class SuppliersController {
    private final SupplierService supplierService;

    @Autowired
    public SuppliersController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping
    public String showSuppliersPage(Model model) {
        model.addAttribute("suppliers", supplierService.findAll());
        return "supplier/suppliers-page";
    }

    @GetMapping("/add")
    @Secured("ROLE_ADMIN")
    public String showAddProductForm(Model model) {
        Supplier supplier = new Supplier();
        model.addAttribute("supplier", supplier);
        return "supplier/supplier-edit";
    }

    @GetMapping("/edit/{id}")
    @Secured("ROLE_ADMIN")
    public String showEditProductForm(Model model, @PathVariable(value = "id") int id) {
        Supplier supplier = supplierService.findById(id);
        model.addAttribute("supplier", supplier);
        return "redirect:/suppliers/add";
    }

    @PostMapping("/edit")
    @Secured("ROLE_ADMIN")
    public String addProduct(@ModelAttribute(value = "supplier") Supplier supplier) {
        supplierService.saveOrUpdate(supplier);
        return "redirect:/suppliers";
    }

    @GetMapping("/delete")
    @Secured("ROLE_ADMIN")
    public String deleteById(@ModelAttribute(value = "id") int id) {
        supplierService.remove(id);
        return "redirect:/suppliers";
    }
}
