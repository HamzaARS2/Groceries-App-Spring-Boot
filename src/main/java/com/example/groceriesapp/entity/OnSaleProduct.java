package com.example.groceriesapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "on_sale_products")
public class OnSaleProduct {

    @Id @GeneratedValue
    private Integer id;
    @NonNull
    private Integer productId;
    @NonNull
    @Column(name = "sale_price")
    private BigDecimal salePrice;
    @NonNull
    @Column(name = "discount_percentage")
    private BigDecimal discountPercentage;
    @NonNull
    @Column(name = "start_date")
    private Date startDate;
    @NonNull
    @Column(name = "end_date")
    private Date endDate;

}
