package com.demo.SpringBoot_Azure.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(name = "order_create_date", nullable = false)
    private OffsetDateTime orderCreateDate;

    @Column(name = "order_update_date")
    private OffsetDateTime orderUpdateDate;

    @Column(name = "country")
    private String country;

    @Column(name = "order_price", nullable = false)
    private BigDecimal orderPrice;

    @OneToOne(mappedBy = "order", cascade = CascadeType.PERSIST)
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Manufacturer> manufacturerList = new ArrayList<>();
}
