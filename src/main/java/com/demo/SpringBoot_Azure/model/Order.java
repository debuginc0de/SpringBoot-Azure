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
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
        @SequenceGenerator(name = "order_seq", sequenceName = "order_seq", allocationSize = 1)
        private Long id;

        @Column(name = "order_id", nullable = false, unique = true)
        private String orderId;

        @Column(name = "order_create_date", nullable = false)
        private OffsetDateTime orderCreateDate;

        @Column(name = "order_update_date")
        private OffsetDateTime orderUpdateDate;

        @Column(name = "country")
        private String country;

        @Column(name = "order_price", nullable = false)
        private BigDecimal orderPrice;

        @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        @JoinColumn(name = "order_id", referencedColumnName = "id", insertable = false, updatable = false)
        private Customer customer;

        @OneToMany(mappedBy = "order", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
        private List<Manufacturer> manufacturers = new ArrayList<>();

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
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

        public List<Manufacturer> getManufacturers() {
            return manufacturers;
        }

        public void setManufacturers(List<Manufacturer> manufacturers) {
            this.manufacturers = manufacturers;
        }
    }
