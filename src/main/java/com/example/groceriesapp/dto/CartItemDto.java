package com.example.groceriesapp.dto;

import com.example.groceriesapp.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDto {
    private int id;
    private String customerId;
    private int productId;
    private int quantity;
    private String createdAt;
    private String updatedAt;
    private Product product;
}
