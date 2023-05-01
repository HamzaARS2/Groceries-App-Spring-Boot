package com.example.groceriesapp.response;

import com.example.groceriesapp.entity.Address;
import com.example.groceriesapp.entity.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private String trackNumber;
    private String status;
    private LocalDate estimatedDeliveryDate;
    private Address deliveryAddress;
    private String paymentInfo;
    private BigDecimal totalPrice;
    private Timestamp timestamp;
    private List<OrderItem> orderItems;
//    private BigDecimal subtotal;
//    private BigDecimal tax;
//    private BigDecimal shipping;
}
