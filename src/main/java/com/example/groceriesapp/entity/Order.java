package com.example.groceriesapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order{
    @Id @GeneratedValue
    private Integer id;
    @NonNull
    @Column(name = "customer_id")
    private Integer customerId;
    @NonNull
    private String status;
    @NonNull
    @Column(name = "total_price")
    private BigDecimal totalPrice;
    @NonNull
    private Timestamp timestamp;

}


