package com.example.groceriesapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {
    private Integer productId;
    private Integer quantity;
    private BigDecimal subTotalPrice;
}
