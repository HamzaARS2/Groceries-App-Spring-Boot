package com.example.groceriesapp.repository;

import com.example.groceriesapp.entity.FavoriteProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FavoriteProductRepo extends JpaRepository<FavoriteProduct, Integer> {
    List<FavoriteProduct> findByCustomerId(String id);
    @Query("DELETE FROM favorite_products p WHERE p.customerId = :customerId AND p.productId = :productId")
    void deleteByCustomerIdAndProductId(String customerId, Integer productId);
}
