package com.example.groceriesapp.dto;

import com.example.groceriesapp.entity.Discount;
import com.example.groceriesapp.entity.Product;
import com.example.groceriesapp.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetails {

    private Integer id;
    private Integer categoryId;
    private String name;
    private String description;
    private BigDecimal price;
    private String priceUnit;
    private String image;
    private Integer discountId;
    private boolean isExclusive;
    private Integer stock;
    private float rating;
    private Discount discount;
    private List<Review> reviews;
    private List<Product> similarProducts;

}
