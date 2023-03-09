package com.example.groceriesapp.repository;

import com.example.groceriesapp.entity.FavoriteProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteProductRepo extends JpaRepository<FavoriteProduct, Integer> {
    List<FavoriteProduct> findByCustomerId(String id);
}