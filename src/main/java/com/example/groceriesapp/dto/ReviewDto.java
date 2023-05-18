package com.example.groceriesapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {
    private Integer productId;
    private String customerId;
    private String comment;
    private Float rating;
}
