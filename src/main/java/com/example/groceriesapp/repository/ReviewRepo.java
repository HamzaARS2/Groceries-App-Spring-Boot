package com.example.groceriesapp.repository;

import com.example.groceriesapp.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepo extends JpaRepository<Review, Integer> {

    List<Review> findByProductId(Integer id);

    Optional<Review> findByCustomerIdAndProductId(String customerId, Integer productId);
}
