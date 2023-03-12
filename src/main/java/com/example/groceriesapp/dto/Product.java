package com.example.groceriesapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Integer id;
    private Integer categoryId;
    private String name;
    private BigDecimal price;
    private String priceUnit;
    private String image;
    private Boolean isExclusive;
}
