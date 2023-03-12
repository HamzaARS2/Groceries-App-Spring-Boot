package com.example.groceriesapp.controller;

import com.example.groceriesapp.dto.Product;
import com.example.groceriesapp.dto.ProductDto;
import com.example.groceriesapp.entity.ProductDetails;
import com.example.groceriesapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService service;



    @GetMapping("/details")
    public List<ProductDetails> findAllProductsDetails() {
        return service.getProductsDetails();
    }

    @GetMapping
    public List<Product> findAllProducts() {
        return service.getProducts();
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


    @GetMapping("/most_rated")
    public List<Product> findMostRatedProducts() {
        return service.getMostRatedProducts();
    }

    @GetMapping("/exclusive")
    public List<Product> findExclusiveProducts() {
        return service.getExclusiveProducts();
    }

    @GetMapping("/shop")
    public List<ProductDetails> findProducts() {
        return service.getShopProducts();
    }

    @GetMapping("/search")
    public List<Product> searchProductsByName(@RequestParam String query) {
        return service.searchProductsByName(query);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        return service.deleteProduct(id);
    }
}
