package com.example.groceriesapp.service;

import com.example.groceriesapp.dto.OrderDto;
import com.example.groceriesapp.dto.OrderItemDto;
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

    @Autowired
    private OrderItemRepo orderItemRepo;


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

    public Order saveOrder(OrderDto orderDto) {
        Order newOrder = repository.save(new Order(orderDto.getCustomerId(), orderDto.getTotalPrice()));
        for (OrderItemDto orderItemDto : orderDto.getOrderItemDtos()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(newOrder.getId());
            orderItem.setProductId(orderItemDto.getProductId());
            orderItem.setQuantity(orderItemDto.getQuantity());
            orderItem.setSubTotalPrice(orderItemDto.getSubTotalPrice());
            orderItemRepo.save(orderItem);
        }
        return newOrder;
    }
}
