package com.example.groceriesapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteProductDto {
        private Integer id;
        private String customerId;
        private Integer productId;
        private String createdAt;
        private Product product;

}
