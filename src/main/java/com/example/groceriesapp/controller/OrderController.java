package com.example.groceriesapp.controller;

import com.example.groceriesapp.entity.Category;
import com.example.groceriesapp.entity.Order;
import com.example.groceriesapp.service.CategoryService;
import com.example.groceriesapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService service;



    @GetMapping("/orders")
    public List<Order> findAllOrders() {
        return service.getOrders();
    }

    @PostMapping("/order/add")
    public Order addOrder(@RequestBody Order order) {
        return service.insertOrder(order);
    }

    @PostMapping("/orders/add")
    public List<Order> addOrders(@RequestBody List<Order> orders) {
        return service.insertOrders(orders);
    }

    @GetMapping("/orders/{id}")
    public Order findOrderById(@PathVariable Integer id) {
        return service.getOrderById(id);
    }

    @DeleteMapping("/order/delete/{id}")
    public String deleteOrder(@PathVariable Integer id) {
        return service.deleteOrder(id);
    }
}
