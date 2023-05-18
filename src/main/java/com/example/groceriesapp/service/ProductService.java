package com.example.groceriesapp.service;

import com.example.groceriesapp.dto.ProductDetails;
import com.example.groceriesapp.dto.ProductReviewDto;
import com.example.groceriesapp.entity.Order;
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

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProductService {
    @Autowired
    private ProductRepo repository;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private OrderService orderService;


    public List<Product> getProductsDetails() {
        return repository.findAll();
    }

    public ProductDetails getProductDetailsById(int id) {
        Product product = repository.findById(id).orElse(null);
        if (product == null) return null;
        List<Review> reviews = reviewService.getReviewsByProductId(id);
        product.setRating(product.calculateRating(reviews));
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
            product.setImage(updatedProduct.getImage());
            return repository.save(product);
        }
        return null;
    }

    public Product getProductById(Integer id) {
        return repository.findById(id).orElse(null);
    }


    public List<Product> searchProductsByName(String query, int categoryId) {
        if (categoryId == 0) return repository.findByNameContaining(query);
        return repository.findByCategoryAndNameContaining(query, categoryId);
    }

    public List<Product> getShopProducts() {
        List<Product> products = repository.findMostRatedAndExclusive();
        List<Product> discountProducts = repository.findAllWithDiscount();
        return Stream.of(products, discountProducts)
                .flatMap(Collection::stream)
                .distinct()
                .sorted(Comparator.comparing(Product::getCreatedAt, Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }


    public String deleteProduct(Integer id) {
        repository.deleteById(id);
        return "Product deleted Successfully : id = " + id;
    }


    public List<ProductReviewDto> getOrderProducts(Integer orderId) {
        Order order = orderService.getOrderById(orderId);
        List<ProductReviewDto> orderProducts = new ArrayList<>();
        order.getOrderItems().forEach(item -> {
                    Product product = repository.findById(item.getProductId()).orElse(null);
                    if (product != null) {
                        Optional<Review> review = reviewService.getCustomerProductReview(order.getCustomerId(), product.getId());
                        ProductReviewDto productReviewDto;
                        productReviewDto = review.map(
                                productReview -> ProductMapper.toProductReview(product, productReview.getRating(), true, productReview.getComment()))
                                .orElseGet(() -> ProductMapper.toProductReview(product, 0, false, ""));
                        orderProducts.add(productReviewDto);
                    }
                }
        );
        return orderProducts;
    }
}
