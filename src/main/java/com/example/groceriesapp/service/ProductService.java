package com.example.groceriesapp.service;

import com.example.groceriesapp.dto.ProductDetails;
import com.example.groceriesapp.entity.Product;
import com.example.groceriesapp.entity.Review;
import com.example.groceriesapp.mapper.ProductMapper;
import com.example.groceriesapp.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Autowired
    private ReviewService reviewService;



    public List<Product> getProductsDetails() {
        return repository.findAll();
    }

    public ProductDetails getProductDetailsById(int id) {
        Product product = repository.findById(id).orElse(null);
        if (product == null) return null;
        List<Review> reviews = reviewService.getReviewsByProductId(id);
        List<Product> similarProducts = repository.findProductsByCategoryId(product.getCategoryId());
        similarProducts.removeIf(item -> item.getId().equals(product.getId()));
        return ProductMapper.toProductDetails(product, reviews, similarProducts);
    }

    public Product insertProduct(Product Product) {
        return repository.save(Product);
    }

    public List<Product> insertProducts(List<Product> products) {
        return repository.saveAll(products);
    }

    public List<Product> getProducts() {
        return repository.findAllProducts();
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


    public Page<Product> searchProductsByName(String query, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("name"));
        return repository.findByNameContaining(query, pageable);
    }

    public List<Product> getShopProducts() {
        List<Product> products =  repository.findMostRatedAndExclusive();
        List<Product> discountProducts = repository.findAllWithDiscount();
        return Stream.of(products,discountProducts)
                .flatMap(Collection::stream)
                .distinct()
                .sorted(Comparator.comparing(Product::getCreatedAt,Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }


    public String deleteProduct(Integer id) {
        repository.deleteById(id);
        return "Product deleted Successfully : id = " + id;
    }


}
