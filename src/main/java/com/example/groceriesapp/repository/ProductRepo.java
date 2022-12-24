package com.example.groceriesapp.repository;

import com.example.groceriesapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {
}
