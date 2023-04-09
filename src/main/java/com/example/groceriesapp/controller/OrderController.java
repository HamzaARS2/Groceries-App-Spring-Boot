package com.example.groceriesapp.controller;

import com.example.groceriesapp.dto.OrderDto;
import com.example.groceriesapp.entity.Category;
import com.example.groceriesapp.entity.Order;
import com.example.groceriesapp.response.OrderResponse;
import com.example.groceriesapp.service.CategoryService;
import com.example.groceriesapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService service;


    @GetMapping
    public List<Order> findAllOrders() {
        return service.getOrders();
    }

    @PostMapping("/add")
    public Order addOrder(@RequestBody Order order) {
        return service.insertOrder(order);
    }

    @PostMapping
    public OrderResponse createOrder(@RequestBody OrderDto orderDto) {
        return service.saveOrder(orderDto);
    }


    @GetMapping("/{id}")
    public Order findOrderById(@PathVariable Integer id) {
        return service.getOrderById(id);
    }

    @GetMapping("/customer/{id}")
    public List<Order> getOrdersByCustomerId(@PathVariable String id) {
        return service.getOrdersByCustomerId(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Integer id) {
        return service.deleteOrder(id);
    }
}
