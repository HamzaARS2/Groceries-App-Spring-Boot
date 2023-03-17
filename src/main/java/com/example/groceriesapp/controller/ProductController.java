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



    @GetMapping("/shop")
    public List<Product> findProducts() {
        return service.getShopProducts();
    }

    @GetMapping("/search")
    public ResponseEntity<Page<Product>> searchProductsByName(
            @RequestParam("query") String query, @RequestParam("page") int page, @RequestParam("size") int pageSize
    ) {
        return ResponseEntity.ok(service.searchProductsByName(query, page, pageSize));
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
