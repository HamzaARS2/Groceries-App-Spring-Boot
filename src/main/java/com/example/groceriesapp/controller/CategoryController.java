package com.example.groceriesapp.controller;

import com.example.groceriesapp.entity.Category;
import com.example.groceriesapp.entity.Product;
import com.example.groceriesapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService service;

    @GetMapping("/categories")
    public List<Category> findAllCategories() {
        return service.getCategories();
    }

    @PostMapping("/category/add")
    public Category addCategory(@RequestBody Category Category) {
        return service.insertCategory(Category);
    }

    @PostMapping("/categories/add")
    public List<Category> addCategories(@RequestBody List<Category> categories) {
        return service.insertCategories(categories);
    }

    @GetMapping("/categories/{id}/products")
    public Category addCategoryProducts(@PathVariable Integer id, @RequestBody List<Product> products) {
        return service.insertCategoryProducts(id, products);
    }

    @GetMapping("/categories/{id}")
    public Category findCategoryById(@PathVariable Integer id) {
        return service.getCategoryById(id);
    }

    public Category findCategoryByName(@PathVariable String name) {
        return service.getCategoryByName(name);
    }

    @DeleteMapping("/categories/delete/{id}")
    public String deleteCategory(@PathVariable Integer id) {
        return service.deleteCategory(id);
    }
}
