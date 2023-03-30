package com.example.groceriesapp.service;

import com.example.groceriesapp.dto.OrderDto;
import com.example.groceriesapp.dto.OrderItemDto;
import com.example.groceriesapp.entity.Customer;
import com.example.groceriesapp.entity.Order;
import com.example.groceriesapp.entity.OrderItem;
import com.example.groceriesapp.mapper.OrderMapper;
import com.example.groceriesapp.repository.CustomerRepo;
import com.example.groceriesapp.repository.OrderItemRepo;
import com.example.groceriesapp.repository.OrderRepo;
import com.example.groceriesapp.response.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class OrderService {
    private final Random random = new Random();
    @Autowired
    private OrderRepo repository;

    @Autowired
    private OrderItemRepo orderItemRepo;

    @Autowired
    private CustomerRepo customerRepo;


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

    public OrderResponse saveOrder(OrderDto orderDto) {
        Order newOrder = repository.save(new Order(orderDto.getCustomerId(), orderDto.getTotalPrice(), generateTrackNumber()));
        for (OrderItemDto orderItemDto : orderDto.getOrderItemDtos()) {
            OrderItem orderItem = new OrderItem();

            orderItem.setOrderId(newOrder.getId());
            orderItem.setProductId(orderItemDto.getProductId());
            orderItem.setQuantity(orderItemDto.getQuantity());
            orderItem.setSubTotalPrice(orderItemDto.getSubTotalPrice());

            orderItemRepo.save(orderItem);
        }
        Customer customer = customerRepo.findById(orderDto.getCustomerId()).orElse(null);
        return OrderMapper.asOrderResponse(newOrder,
                customer == null ? null : customer.getAddress());
    }

    public String generateTrackNumber() {
        long timestamp = System.currentTimeMillis();
        int randomNumber = random.nextInt(1000);
        return "Grocery#" + timestamp + randomNumber;
    }
}
