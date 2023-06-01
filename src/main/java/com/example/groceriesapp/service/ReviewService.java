package com.example.groceriesapp.service;

import com.example.groceriesapp.dto.ReviewDto;
import com.example.groceriesapp.entity.Product;
import com.example.groceriesapp.entity.Review;
import com.example.groceriesapp.repository.ProductRepo;
import com.example.groceriesapp.repository.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepo repository;

    @Autowired
    private ProductRepo productRepo;


    public List<Review> getReviewsByProductId(Integer id) {
        return repository.findByProductId(id);
    }

    public Optional<Review> getCustomerProductReview(String customerId, Integer productId) {
        return repository.findByCustomerIdAndProductId(customerId, productId);
    }




    public Review saveReview(ReviewDto reviewDto) {
        Review existingReview = repository.findByCustomerIdAndProductId(reviewDto.getCustomerId(), reviewDto.getProductId()).orElse(null);
        if (existingReview != null) {
            existingReview.setRating(reviewDto.getRating());
            existingReview.setComment(reviewDto.getComment());
            return repository.save(existingReview);
        }
        Review newReview = new Review(reviewDto.getProductId(), reviewDto.getCustomerId(), reviewDto.getComment(), reviewDto.getRating());
        return repository.save(newReview);
    }

    private void updateRating(float rating, Integer id) throws NullPointerException {
        Product product = productRepo.findById(id).orElse(null);
        if (product != null) {
            float currentRating = product.getRating();
            if (currentRating == 0.0F) {
                product.setRating(rating);
                productRepo.save(product);
                return;
            }
            float newRating = (currentRating + rating) / 2;
            product.setRating(newRating);
            productRepo.save(product);
            return;
        }
        throw new NullPointerException("Cannot find the product with this id : " +id);
    }

}
