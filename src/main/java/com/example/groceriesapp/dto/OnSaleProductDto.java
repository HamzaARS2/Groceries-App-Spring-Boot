package com.example.groceriesapp.dto;

import com.example.groceriesapp.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OnSaleProductDto {

    private Integer id;
    private Integer productId;
    private BigDecimal salePrice;
    private BigDecimal discountPercentage;
    private Date startDate;
    private Date endDate;

    private Product product;
}
