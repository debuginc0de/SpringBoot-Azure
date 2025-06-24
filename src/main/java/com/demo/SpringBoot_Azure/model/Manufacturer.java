package com.demo.SpringBoot_Azure.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "manufacturer")
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mfg_id", nullable = false, unique = true)
    private String mfgId;

    @Column(name = "location")
    private String location;

    @Column(name = "payment_mode")
    private String paymentMode;

    @Column(name = "rating")
    private Double rating;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
