package com.example.groceriesapp.service;

import com.example.groceriesapp.entity.Product;
import com.example.groceriesapp.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo repository;


    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product insertProduct(Product Product) {
        return repository.save(Product);
    }

    public List<Product> insertProducts(List<Product> products) {
        return repository.saveAll(products);
    }

    public Product getProductById(Integer id) {
        return repository.findById(id).orElse(null);
    }


    public String deleteProduct(Integer id) {
        repository.deleteById(id);
        return "Product deleted Successfully : id = " + id;
    }


}
