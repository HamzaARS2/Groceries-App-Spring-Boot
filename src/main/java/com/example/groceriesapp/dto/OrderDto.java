package com.example.groceriesapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private String customerId;
    private Integer addressId;
    private BigDecimal totalPrice;
    @JsonProperty("orderItems")
    private List<OrderItemDto> orderItemDtos;
}
