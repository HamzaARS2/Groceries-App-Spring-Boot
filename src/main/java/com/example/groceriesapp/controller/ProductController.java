package com.example.groceriesapp.controller;

import com.example.groceriesapp.entity.Category;
import com.example.groceriesapp.entity.Product;
import com.example.groceriesapp.service.CategoryService;
import com.example.groceriesapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService service;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return service.getProducts();
    }

    @PostMapping("/product/add")
    public Product addProduct(@RequestBody Product product) {
        Category category = categoryService.getCategoryById(product.getCategoryId());
        product.setCategory(category);
        return service.insertProduct(product);
    }

    @PostMapping("/products/add")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        for (Product product: products) {
            Category category = categoryService.getCategoryById(product.getCategoryId());
            product.setCategory(category);
        }
        return service.insertProducts(products);
    }

    @GetMapping("/products/{id}")
    public Product findProductById(@PathVariable Integer id) {
        return service.getProductById(id);
    }

    @DeleteMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        return service.deleteProduct(id);
    }
}
