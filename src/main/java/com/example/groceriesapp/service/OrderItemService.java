package com.example.groceriesapp.service;

import com.example.groceriesapp.entity.OrderItem;
import com.example.groceriesapp.repository.OrderItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {
    @Autowired
    private OrderItemRepo repository;


    public List<OrderItem> getOrderItems() {
        return repository.findAll();
    }

    public OrderItem insertOrderItem(OrderItem orderItem) {
        return repository.save(orderItem);
    }

    public List<OrderItem> insertOrderItems(List<OrderItem> orderItems) {
        return repository.saveAll(orderItems);
    }

    public OrderItem getOrderItemById(Integer id) {
        return repository.findById(id).orElse(null);
    }


    public String deleteOrderItem(Integer id) {
        repository.deleteById(id);
        return "OrderItem deleted Successfully : id = " + id;
    }
}
