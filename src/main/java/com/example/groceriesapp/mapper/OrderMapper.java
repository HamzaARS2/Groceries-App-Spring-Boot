package com.example.groceriesapp.mapper;

import com.example.groceriesapp.entity.Address;
import com.example.groceriesapp.entity.Order;
import com.example.groceriesapp.response.OrderResponse;

public class OrderMapper {

    public static OrderResponse asOrderResponse(Order order, Address address) {
        return new OrderResponse(
                order.getTrackNumber(), order.getStatus(),
                order.getEstimatedDeliveryDate(), address,
                order.getPaymentInfo(), order.getTotalPrice(),
                order.getTimestamp(),
                order.getOrderItems()
        );
    }
}
