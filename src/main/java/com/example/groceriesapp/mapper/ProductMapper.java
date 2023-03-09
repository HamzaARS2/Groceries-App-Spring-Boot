package com.example.groceriesapp.mapper;

import com.example.groceriesapp.dto.ProductDto;
import com.example.groceriesapp.entity.ProductDetails;

public class ProductMapper {


    public static ProductDto toProductDTO(ProductDetails productDetails) {
        return new ProductDto(
                productDetails.getId(),
                productDetails.getCategoryId(),
                productDetails.getName(),
                productDetails.getPrice(),
                productDetails.getPriceUnit(),
                productDetails.getImage()
        );
    }
}
