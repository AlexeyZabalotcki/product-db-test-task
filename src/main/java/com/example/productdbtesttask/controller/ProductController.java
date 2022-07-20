package com.example.productdbtesttask.controller;

import com.example.productdbtesttask.entity.Product;
import com.example.productdbtesttask.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@Controller
@RequestMapping("products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String showProductsPage(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product/product-page";
    }

    @GetMapping("/add")
    public String showAddProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "product/product-edit";
    }

    @GetMapping("/edit/{id}")
    public String showEditProductForm(Model model, @PathVariable(value = "id") int id) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "product/product-edit";
    }

    @PostMapping("/edit")
    public String addProduct(@ModelAttribute(value = "product") Product product) {
        productService.saveOrUpdate(product);
        return "redirect:/products";
    }

    @GetMapping("/delete")
    public String deleteById(@ModelAttribute(value = "id") int id) {
        Product product = productService.findById(id);

        if (product == null) {
            throw new NoSuchElementException("Product with id= " + id + " not found");
        }
        productService.remove(id);

        return "redirect:/products";
    }
}
