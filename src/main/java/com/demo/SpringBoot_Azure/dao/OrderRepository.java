package com.demo.SpringBoot_Azure.dao;

import com.demo.SpringBoot_Azure.model.Order;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
