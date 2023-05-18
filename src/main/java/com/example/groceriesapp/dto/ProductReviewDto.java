package com.example.groceriesapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.annotations.SerializedName;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    private float customerRating;
    private String customerComment;
    private Boolean reviewed;
}
