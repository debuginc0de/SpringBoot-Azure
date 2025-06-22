package com.demo.SpringBoot_Azure.model;

import jakarta.persistence.*;
import lombok.Data;

    @Data
    @Entity
    @Table(name = "address")
    public class Address {
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
        @SequenceGenerator(name = "address_seq", sequenceName = "address_seq", allocationSize = 1)
        private Long id;

        @Column(name = "country")
        private String country;

        @Column(name = "state")
        private String state;

        @Column(name = "street")
        private String street;

        @Column(name = "pin_code")
        private String pinCode;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "customer_id")
        private Customer customer;

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getPinCode() {
            return pinCode;
        }

        public void setPinCode(String pinCode) {
            this.pinCode = pinCode;
        }

        public Customer getCustomer() {
            return customer;
        }

        public void setCustomer(Customer customer) {
            this.customer = customer;
        }
    }
