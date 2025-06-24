package com.demo.SpringBoot_Azure.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country")
    private String country;

    @Column(name = "state")
    private String state;

    @Column(name = "street")
    private String street;

    @Column(name = "pin_code")
    private String pinCode;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "customer_id", unique = true)
    private Customer customer;
}
