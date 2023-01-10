package com.example.groceriesapp.controller;

import com.example.groceriesapp.entity.OrderItem;
import com.example.groceriesapp.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderItems")
public class OrderItemController {
    @Autowired
    private OrderItemService service;

    @GetMapping
    public List<OrderItem> findAllOrderItems() {
        return service.getOrderItems();
    }

    @PostMapping("/add")
    public OrderItem addOrderItem(@RequestBody OrderItem orderItem) {
        return service.insertOrderItem(orderItem);
    }

    @PostMapping("/addList")
    public List<OrderItem> addOrderItems(@RequestBody List<OrderItem> orderItems) {
        return service.insertOrderItems(orderItems);
    }

    @GetMapping("/{id}")
    public OrderItem findOrderItemById(@PathVariable Integer id) {
        return service.getOrderItemById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteOrderItem(@PathVariable Integer id) {
        return service.deleteOrderItem(id);
    }
}
