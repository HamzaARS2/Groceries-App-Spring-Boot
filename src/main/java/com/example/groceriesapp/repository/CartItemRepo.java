package com.example.groceriesapp.repository;

import com.example.groceriesapp.dto.CartItemDto;
import com.example.groceriesapp.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartItemRepo extends JpaRepository<CartItem, Integer> {

    List<CartItem> findByCustomerId(String id);

    CartItem findByCustomerIdAndProductId(String customerId, Integer productId);


}
