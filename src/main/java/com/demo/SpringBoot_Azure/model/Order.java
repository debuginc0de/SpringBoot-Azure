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

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public OffsetDateTime getOrderCreateDate() {
        return orderCreateDate;
    }

    public void setOrderCreateDate(OffsetDateTime orderCreateDate) {
        this.orderCreateDate = orderCreateDate;
    }

    public OffsetDateTime getOrderUpdateDate() {
        return orderUpdateDate;
    }

    public void setOrderUpdateDate(OffsetDateTime orderUpdateDate) {
        this.orderUpdateDate = orderUpdateDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Manufacturer> getManufacturerList() {
        return manufacturerList;
    }

    public void setManufacturerList(List<Manufacturer> manufacturerList) {
        this.manufacturerList = manufacturerList;
    }
}
