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
import java.time.LocalDate;
import java.util.Date;
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

    @Column(name = "address_id")
    private Integer addressId;
    private String status;
    @Column(name = "track_number")
    private String trackNumber;

    @Column(name = "estimated_date")
    private LocalDate estimatedDeliveryDate;
    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Column(name = "payment_info")
    private String paymentInfo;
    @CreationTimestamp
    @ColumnDefault("CURRENT_TIMESTAMP")
    private Timestamp timestamp;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderId", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;



    public Order(String customerId,Integer addressId, BigDecimal totalPrice, String trackNumber) {
        this.customerId = customerId;
        this.totalPrice = totalPrice;
        this.trackNumber = trackNumber;
        this.addressId = addressId;
        this.status = "Pending";
        this.paymentInfo = "CASH";
        this.estimatedDeliveryDate = LocalDate.now().plusDays(3);
    }

}


