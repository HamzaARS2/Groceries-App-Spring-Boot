package com.example.groceriesapp.mapper;


import com.example.groceriesapp.dto.ProductDetails;
import com.example.groceriesapp.dto.ProductReviewDto;
import com.example.groceriesapp.entity.CartItem;
import com.example.groceriesapp.entity.Product;
import com.example.groceriesapp.entity.Review;

import java.util.List;

public class ProductMapper {


    public static ProductDetails toProductDetails(Product product, List<Review> reviews, List<Product> similarProducts) {
        return new ProductDetails(
                product.getId(),
                product.getCategoryId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getPriceUnit(),
                product.getImage(),
                product.getDiscountId(),
                product.isExclusive(),
                product.getRating(),
                product.getDiscount(),
                reviews,
                similarProducts
        );
    }

    public static ProductReviewDto toProductReview(Product product, Boolean reviewed) {
        return new ProductReviewDto(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getPriceUnit(),
                product.getImage(),
                product.getRating(),
                reviewed
        );
    }




}















