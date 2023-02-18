package com.example.groceriesapp.controller;

import com.example.groceriesapp.dto.ProductDTO;
import com.example.groceriesapp.entity.ProductDetails;
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
    public List<ProductDetails> findAllProducts() {
        return service.getProductDetails();
    }

    @PostMapping("/add")
    public ProductDetails addProduct(@RequestBody ProductDetails product) {
        return service.insertProduct(product);
    }

    @PutMapping("/update/{id}")
    public ProductDetails updateProduct(@PathVariable Integer id, @RequestBody ProductDetails product) {
        return service.updateProduct(id,product);
    }

    @GetMapping("/{id}")
    public ProductDetails findProductById(@PathVariable Integer id) {
        return service.getProductDetailsById(id);
    }



    @GetMapping("/exclusive")
    public List<ProductDTO> findExclusiveProducts() {
        return service.getExclusiveProducts();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        return service.deleteProduct(id);
    }
}
