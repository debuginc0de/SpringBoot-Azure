package com.demo.SpringBoot_Azure.Service;

import com.demo.SpringBoot_Azure.dao.OrderRepository;
import com.demo.SpringBoot_Azure.model.Order;

import java.util.List;
import java.util.Optional;

public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }
    public List<Order> getOrder(){
        return orderRepository.findAll();
    }
    public Optional<Order> getOrderById(Long id){
        return orderRepository.findById(id);
    }
}
