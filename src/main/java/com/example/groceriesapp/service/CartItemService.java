package com.example.groceriesapp.service;

import com.example.groceriesapp.dto.CartItemDto;
import com.example.groceriesapp.entity.CartItem;
import com.example.groceriesapp.entity.Product;
import com.example.groceriesapp.mapper.ProductMapper;
import com.example.groceriesapp.repository.CartItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartItemService {

    @Autowired
    private CartItemRepo repository;


    public List<CartItem> getCustomerCartItems(String id) {
        return repository.findByCustomerId(id);
    }

    public CartItem addCartItem(String customerId, int productId) {
        CartItem exisingCartItem = repository.findByCustomerIdAndProductId(customerId, productId);
        if (exisingCartItem != null)
            return exisingCartItem;
        return repository.save(new CartItem(customerId, productId, 1));
    }

    public void deleteCartItem(Integer id) {
        repository.deleteById(id);
    }

    public List<CartItem> saveMultipleCartItems(String customerId, int[] productIds) {
        List<CartItem> savedCartItems = new ArrayList<>();
        for (int id : productIds) {
            savedCartItems.add(addCartItem(customerId, id));
        }
        return savedCartItems;
    }
}
