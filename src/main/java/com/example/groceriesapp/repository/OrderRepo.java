package com.example.groceriesapp.repository;

import com.example.groceriesapp.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order,Integer> {
    List<Order> findAllByCustomerId(String id);
}
