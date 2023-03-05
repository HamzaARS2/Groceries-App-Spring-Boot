package com.example.groceriesapp.controller;

import com.example.groceriesapp.entity.Category;
import com.example.groceriesapp.entity.ProductDetails;
import com.example.groceriesapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @GetMapping
    public List<Category> findAllCategories() {
        return service.getCategories();
    }

    @PostMapping("/add")
    public Category addCategory(@RequestBody Category Category) {
        return service.insertCategory(Category);
    }



    @GetMapping("/{id}")
    public Category findCategoryById(@PathVariable Integer id) {
        return service.getCategoryById(id);
    }
    @PutMapping("/update/{id}")
    public Category updateCategory(@PathVariable Integer id, @RequestBody Category updatedCategory) {
        return service.updateCategory(id,updatedCategory);
    }

    public Category findCategoryByName(@PathVariable String name) {
        return service.getCategoryByName(name);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Integer id) {
        return service.deleteCategory(id);
    }
}
