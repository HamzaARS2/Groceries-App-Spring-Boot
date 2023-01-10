package com.example.groceriesapp.service;

import com.example.groceriesapp.entity.Order;
import com.example.groceriesapp.entity.OrderItem;
import com.example.groceriesapp.repository.OrderItemRepo;
import com.example.groceriesapp.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepo repository;


    public List<Order> getOrders() {
        return repository.findAll();
    }

    public Order insertOrder(Order order) {
        return repository.save(order);
    }

    public List<Order> insertOrders(List<Order> orders) {
        return repository.saveAll(orders);
    }

    public List<Order> getOrdersByCustomerId(Integer id) {
        return repository.findAllByCustomerId(id);
    }

    public Order getOrderById(Integer id) {
        return repository.findById(id).orElse(null);
    }


    public String deleteOrder(Integer id) {
        repository.deleteById(id);
        return "Order deleted Successfully : id = " + id;
    }
}
