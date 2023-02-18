package com.example.groceriesapp.service;

import com.example.groceriesapp.entity.Review;
import com.example.groceriesapp.repository.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepo repository;


    public List<Review> getReviewsByProductId(Integer id) {
        return repository.findByProductId(id);
    }
}
