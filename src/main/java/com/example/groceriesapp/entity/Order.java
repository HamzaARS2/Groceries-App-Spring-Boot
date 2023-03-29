package com.example.groceriesapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order{
    @Id @GeneratedValue
    private Integer id;
    @Column(name = "customer_id")
    private String customerId;
    private String status;
    @Column(name = "total_price")
    private BigDecimal totalPrice;
    @CreationTimestamp
    @ColumnDefault("CURRENT_TIMESTAMP")
    private Timestamp timestamp;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderId", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;


    public Order(String customerId, BigDecimal totalPrice) {
        this.customerId = customerId;
        this.totalPrice = totalPrice;
    }

}


