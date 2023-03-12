package com.example.groceriesapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name = "discounts")
public class Discount {

    @Id @GeneratedValue
    private Integer id;
    @NonNull
    @Column(name = "sale_price")
    private BigDecimal salePrice;
    @NonNull
    @Column(name = "discount_percentage")
    private BigDecimal discountPercentage;
    @NonNull
    @Column(name = "start_date")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date startDate;
    @NonNull
    @Column(name = "end_date")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date endDate;


}
