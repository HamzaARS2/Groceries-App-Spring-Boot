package com.example.groceriesapp.mapper;

import com.example.groceriesapp.dto.ProductDTO;
import com.example.groceriesapp.entity.ProductDetails;

public class ProductMapper {


    public static ProductDTO toProductDTO(ProductDetails productDetails) {
        return new  ProductDTO(
                productDetails.getId(),
                productDetails.getCategoryId(),
                productDetails.getName(),
                productDetails.getPrice(),
                productDetails.getPriceUnit(),
                productDetails.getImage()
        );
    }
}
