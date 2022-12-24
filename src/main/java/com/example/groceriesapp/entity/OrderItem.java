package com.example.groceriesapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_items")
public class OrderItem {
    @Id @GeneratedValue
    private Integer id;
    @NonNull
    @Column(name = "order_id", insertable=false, updatable=false)
    private Integer orderId;
    @NonNull
    @Column(name = "product_id")
    private Integer productId;
    @NonNull
    private Integer quantity;
    @NonNull
    @Column(name = "subtotal_price")
    private BigDecimal subTotalPrice;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

}
