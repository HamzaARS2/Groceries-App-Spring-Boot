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

    public Product updateProduct(Integer id, Product updatedProduct) {
        Product product = repository.findById(id).orElse(null);
        if (product != null) {
            product.setCategoryId(updatedProduct.getCategoryId());
            product.setName(updatedProduct.getName());
            product.setDescription(updatedProduct.getDescription());
            product.setPrice(updatedProduct.getPrice());
            product.setPriceUnit(updatedProduct.getPriceUnit());
            product.setNutrition(updatedProduct.getNutrition());
            product.setImage(updatedProduct.getImage());
            return repository.save(product);
        }
        return null;
    }

    public Product getProductById(Integer id) {
        return repository.findById(id).orElse(null);
    }


    public String deleteProduct(Integer id) {
        repository.deleteById(id);
        return "Product deleted Successfully : id = " + id;
    }


}
