package com.example.groceriesapp.mapper;

import com.example.groceriesapp.dto.OnSaleInfo;
import com.example.groceriesapp.dto.OnSaleProductDto;
import com.example.groceriesapp.dto.Product;
import com.example.groceriesapp.dto.ProductDto;
import com.example.groceriesapp.entity.ProductDetails;

public class ProductMapper {


    public static Product toProduct(ProductDetails productDetails) {
        return new Product(
                productDetails.getId(),
                productDetails.getCategoryId(),
                productDetails.getName(),
                productDetails.getPrice(),
                productDetails.getPriceUnit(),
                productDetails.getImage(),
                productDetails.isExclusive()
        );
    }

    public static ProductDto toProductDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getCategoryId(),
                product.getName(),
                product.getPrice(),
                product.getPriceUnit(),
                product.getImage(),
                product.getIsExclusive(),
                null

        );
    }

    public static ProductDto toProductDto(OnSaleProductDto onSaleProductDto) {
        Product product = onSaleProductDto.getProduct();
        return new ProductDto(
                product.getId(),
                product.getCategoryId(),
                product.getName(),
                product.getPrice(),
                product.getPriceUnit(),
                product.getImage(),
                product.getIsExclusive(),
                new OnSaleInfo(
                        onSaleProductDto.getSalePrice(),
                        onSaleProductDto.getDiscountPercentage(),
                        onSaleProductDto.getStartDate(),
                        onSaleProductDto.getEndDate()
                )

        );
    }
}
