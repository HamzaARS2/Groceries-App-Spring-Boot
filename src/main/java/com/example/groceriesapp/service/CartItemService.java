package com.example.groceriesapp.service;

import com.example.groceriesapp.dto.CartItemDto;
import com.example.groceriesapp.dto.Product;
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


    public List<CartItemDto> getCustomerCartItems(String id) {
        List<CartItem> cartItems = repository.findByCustomerId(id);
        List<CartItemDto> cartItemDtos = new ArrayList<>();
        for (CartItem cartItem : cartItems) {
            Product product = ProductMapper.toProduct(cartItem.getProductDetails());
            CartItemDto cartItemDto = new CartItemDto(
                    cartItem.getId(),
                    cartItem.getCustomerId(),
                    cartItem.getProductId(),
                    cartItem.getQuantity(),
                    cartItem.getCreatedAt().toString(),
                    cartItem.getUpdatedAt().toString(),
                    product
            );
            cartItemDtos.add(cartItemDto);
        }
        return cartItemDtos;

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
