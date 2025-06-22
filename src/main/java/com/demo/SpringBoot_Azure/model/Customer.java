package com.demo.SpringBoot_Azure.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
    @Entity
    @Table(name = "customer")
    public class Customer {
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
        @SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq", allocationSize = 1)
        private Long id;

        @Column(name = "customer_id", nullable = false, unique = true)
        private String customerId;

        @Column(name = "customer_email", nullable = false)
        private String customerEmail;

        @Column(name = "customer_phone")
        private String customerPhone;

        @OneToOne(mappedBy = "customer")
        private Order order;

        @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
        private List<Address> addresses = new ArrayList<>();

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getCustomerEmail() {
            return customerEmail;
        }

        public void setCustomerEmail(String customerEmail) {
            this.customerEmail = customerEmail;
        }

        public String getCustomerPhone() {
            return customerPhone;
        }

        public void setCustomerPhone(String customerPhone) {
            this.customerPhone = customerPhone;
        }

        public Order getOrder() {
            return order;
        }

        public void setOrder(Order order) {
            this.order = order;
        }

        public List<Address> getAddresses() {
            return addresses;
        }

        public void setAddresses(List<Address> addresses) {
            this.addresses = addresses;
        }
    }
