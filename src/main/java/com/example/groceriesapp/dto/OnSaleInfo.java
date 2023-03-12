package com.example.groceriesapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OnSaleInfo {
    private BigDecimal salePrice;
    private BigDecimal discountPercentage;
    private Date startDate;
    private Date endDate;
}
