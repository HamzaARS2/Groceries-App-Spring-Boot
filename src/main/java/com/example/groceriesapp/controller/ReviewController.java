package com.example.groceriesapp.controller;

import com.example.groceriesapp.dto.ReviewDto;
import com.example.groceriesapp.entity.Review;
import com.example.groceriesapp.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService service;


    @GetMapping("/product/{id}")
    public List<Review> getReviewsByProductId(@PathVariable Integer id) {
        return service.getReviewsByProductId(id);
    }
    @PostMapping("/save")
    public Review saveReview(@RequestBody ReviewDto reviewDto) {
        return service.saveReview(reviewDto);
    }

}
