package com.example.groceriesapp.controller;

import com.example.groceriesapp.entity.Product;
import com.example.groceriesapp.service.CategoryService;
import com.example.groceriesapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Product> findAllProducts() {
        return service.getProducts();
    }

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
        return service.insertProduct(product);
    }

    @PutMapping("/update/{id}")
    public Product updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        return service.updateProduct(id,product);
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable Integer id) {
        return service.getProductById(id);
    }



    @GetMapping("/exclusive")
    public List<Product> findExclusiveProducts() {
        return service.getExclusiveProducts();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        return service.deleteProduct(id);
    }
}
