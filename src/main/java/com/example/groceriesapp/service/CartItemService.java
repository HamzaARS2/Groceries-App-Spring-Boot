package com.example.groceriesapp.service;

import com.example.groceriesapp.dto.CartItemDto;
import com.example.groceriesapp.entity.CartItem;
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

    public CartItem addCartItem(CartItem cartItem) {
        CartItem exisingCartItem = repository.findByCustomerIdAndProductId(cartItem.getCustomerId(), cartItem.getProductId());
        if (exisingCartItem != null) {
            exisingCartItem.setQuantity(exisingCartItem.getQuantity() + 1);
            return repository.save(exisingCartItem);
        }
        return repository.save(cartItem);
    }

    public void saveMultipleCartItems(List<CartItem> cartItems) {
        for (CartItem cartItem : cartItems) {
            addCartItem(cartItem);
        }
    }

    public void deleteCartItem(Integer id) {
        repository.deleteById(id);
    }
}
