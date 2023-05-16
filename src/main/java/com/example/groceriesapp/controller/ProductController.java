package com.example.groceriesapp.controller;

import com.example.groceriesapp.dto.ProductDetails;
import com.example.groceriesapp.entity.Product;
import com.example.groceriesapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService service;

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


    @GetMapping("/order/{orderId}")
    public List<Product> findOrderProducts(@PathVariable Integer orderId) {
        return service.getOrderProducts(orderId);
    }

    @GetMapping("/shop")
    public List<Product> findProducts() {
        return service.getShopProducts();
    }

    @GetMapping("/search")
    public List<Product> searchProductsByName(@RequestParam("query") String query, @RequestParam("categoryId") int categoryId) {
        return service.searchProductsByName(query, categoryId);
    }

    @GetMapping("/details/{id}")
    public ProductDetails getProductDetailsById(@PathVariable("id") Integer id) {
        return service.getProductDetailsById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        return service.deleteProduct(id);
    }
}
