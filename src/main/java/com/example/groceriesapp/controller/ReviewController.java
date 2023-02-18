package com.example.groceriesapp.controller;

import com.example.groceriesapp.entity.Review;
import com.example.groceriesapp.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService service;


    @GetMapping("/product/{id}")
    public List<Review> getReviewsByProductId(@PathVariable Integer id) {
        return service.getReviewsByProductId(id);
    }

}
