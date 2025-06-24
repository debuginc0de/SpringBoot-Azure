package com.demo.SpringBoot_Azure.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "customer_email", nullable = false)
    private String customerEmail;

    @Column(name = "customer_phone")
    private String customerPhone;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.PERSIST)
    private Address address;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "order_id", unique = true)
    private Order order;
}
