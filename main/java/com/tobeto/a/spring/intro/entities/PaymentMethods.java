package com.tobeto.a.spring.intro.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name = "payment_methods")
@Entity
@Getter
@Setter
public class PaymentMethods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private int paymentId;

    @Column(name = "cash")
    private boolean cash;

    @Column(name="card")
    private boolean card;

    @Column(name = "daily_price")
    private double dailyPrice;

    @Column(name = "weekly_price")
    private double weeklyPrice;

    @OneToMany(mappedBy = "paymentMethods")
    @JsonIgnore
    private List<Customer> customers;

    @OneToMany(mappedBy = "paymentMethods")
    @JsonIgnore
    private List<Car> cars;
}
