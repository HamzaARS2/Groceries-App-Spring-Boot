package com.example.groceriesapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
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
    private ProductDto product;
}
