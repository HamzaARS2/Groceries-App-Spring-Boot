package com.example.groceriesapp.controller;

import com.example.groceriesapp.dto.CartItemDto;
import com.example.groceriesapp.entity.CartItem;
import com.example.groceriesapp.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart_items")
public class CartItemController {

    @Autowired
    private CartItemService service;


     @GetMapping("/{id}")
    public List<CartItem> getCartItems(@PathVariable String id) {
        return service.getCustomerCartItems(id);
    }

    @PostMapping("/create")
    public CartItem addCartItem(@RequestBody CartItem cartItem) {
        return service.addCartItem(cartItem);
    }

    @PostMapping("/multiple/create")
    public void addMultipleCartItems(@RequestBody List<CartItem> cartItems) {
         service.saveMultipleCartItems(cartItems);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCartItem(@PathVariable("id") Integer id) {
         service.deleteCartItem(id);
    }
}
