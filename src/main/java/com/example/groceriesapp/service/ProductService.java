package com.example.groceriesapp.service;

import com.example.groceriesapp.dto.Product;
import com.example.groceriesapp.dto.ProductDto;
import com.example.groceriesapp.entity.Discount;
import com.example.groceriesapp.entity.ProductDetails;
import com.example.groceriesapp.mapper.ProductMapper;
import com.example.groceriesapp.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProductService {
    @Autowired
    private ProductRepo repository;



    public List<ProductDetails> getProductsDetails() {
        return repository.findAll();
    }

    public ProductDetails insertProduct(ProductDetails Product) {
        return repository.save(Product);
    }

    public List<ProductDetails> insertProducts(List<ProductDetails> products) {
        return repository.saveAll(products);
    }

    public List<Product> getProducts() {
        return repository.findAllProducts();
    }


    public ProductDetails updateProduct(Integer id, ProductDetails updatedProduct) {
        ProductDetails product = repository.findById(id).orElse(null);
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

    public ProductDetails getProductDetailsById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public List<Product> getExclusiveProducts() {
        return repository.findByIsExclusiveIsTrue();
    }

    public List<Product> getMostRatedProducts() {
        return repository.findByMostRated();
    }

    public List<Product> searchProductsByName(String query) {
        return repository.findByNameContaining(query);
    }

    public List<ProductDetails> getShopProducts() {
        List<ProductDetails> products =  repository.findMostRatedAndExclusive();
        List<ProductDetails> discountProducts = repository.findAllWithDiscount();
        return Stream.of(products,discountProducts)
                .flatMap(Collection::stream)
                .distinct()
                .sorted(Comparator.comparing(ProductDetails::getId))
                .collect(Collectors.toList());
    }


    public String deleteProduct(Integer id) {
        repository.deleteById(id);
        return "Product deleted Successfully : id = " + id;
    }


}
