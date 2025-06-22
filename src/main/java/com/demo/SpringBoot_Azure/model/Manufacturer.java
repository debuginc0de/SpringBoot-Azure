package com.demo.SpringBoot_Azure.model;

import jakarta.persistence.*;
import lombok.Data;

    @Data
    @Entity
    @Table(name = "manufacturer")
    public class Manufacturer {
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "manufacturer_seq")
        @SequenceGenerator(name = "manufacturer_seq", sequenceName = "manufacturer_seq", allocationSize = 1)
        private Long id;

        @Column(name = "mfg_id", nullable = false, unique = true)
        private String mfgId;

        @Column(name = "location")
        private String location;

        @Column(name = "payment_mode")
        private String paymentMode;

        @Column(name = "rating")
        private Double rating;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "order_id")
        private Order order;

        public String getMfgId() {
            return mfgId;
        }

        public void setMfgId(String mfgId) {
            this.mfgId = mfgId;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getPaymentMode() {
            return paymentMode;
        }

        public void setPaymentMode(String paymentMode) {
            this.paymentMode = paymentMode;
        }

        public Double getRating() {
            return rating;
        }

        public void setRating(Double rating) {
            this.rating = rating;
        }

        public Order getOrder() {
            return order;
        }

        public void setOrder(Order order) {
            this.order = order;
        }
    }
