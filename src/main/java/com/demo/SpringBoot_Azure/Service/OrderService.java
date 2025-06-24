package com.demo.SpringBoot_Azure.Service;

import com.demo.SpringBoot_Azure.dao.OrderRepository;
import com.demo.SpringBoot_Azure.model.Address;
import com.demo.SpringBoot_Azure.model.Customer;
import com.demo.SpringBoot_Azure.model.Manufacturer;
import com.demo.SpringBoot_Azure.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order saveOrder(Order order) {
        Customer customer = order.getCustomer();
        Address address = customer.getAddress();
        /***Always set both sides of a bidirectional relationship manually in your code to ensure consistency.*
         * This ensures consistency in both:
         *
         * Java object graph
         *
         * Database foreign key
         */
        address.setCustomer(customer);
        customer.setOrder(order);
        List<Manufacturer> manufacturerList = order.getManufacturerList();
        for (Manufacturer m : manufacturerList) {
            m.setOrder(order);
        }
        order.setManufacturerList(manufacturerList);
        return orderRepository.save(order);
    }

    public List<Order> getOrder() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }
}
