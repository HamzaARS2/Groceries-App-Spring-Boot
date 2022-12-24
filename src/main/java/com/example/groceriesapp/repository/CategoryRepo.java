package com.example.groceriesapp.repository;

import com.example.groceriesapp.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
    Category findByName(String name);
}
