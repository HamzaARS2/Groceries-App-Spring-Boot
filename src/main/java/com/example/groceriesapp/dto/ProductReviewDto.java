package com.example.groceriesapp.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductReviewDto {
    private Integer id;
    private String name;
    private BigDecimal price;
    private String priceUnit;
    private String image;
    private float rating;
    private Boolean reviewed;
}
