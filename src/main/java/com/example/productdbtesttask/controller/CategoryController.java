package com.example.productdbtesttask.controller;

import com.example.productdbtesttask.entity.Category;
import com.example.productdbtesttask.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public String showCategoriesPage(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "category/category-page";
    }

    @GetMapping("/showCategoryInfo")
    public String showFileInfo(@RequestParam("id") int id,
                               Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "category/category-info";
    }

    @GetMapping("/add")
    @Secured("ROLE_ADMIN")
    public String showAddProductForm(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "category/category-edit";
    }

    @GetMapping("/edit/{id}")
    @Secured("ROLE_ADMIN")
    public String showEditProductForm(Model model, @PathVariable(value = "id") int id) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "redirect:/category/add";
    }

    @PostMapping("/edit")
    @Secured("ROLE_ADMIN")
    public String addProduct(@ModelAttribute(value = "category") Category category) {
        categoryService.saveOrUpdate(category);
        return "redirect:/category";
    }

    @GetMapping("/delete")
    @Secured("ROLE_ADMIN")
    public String deleteById(@ModelAttribute(value = "id") int id) {
        categoryService.remove(id);
        return "redirect:/category";
    }
}
