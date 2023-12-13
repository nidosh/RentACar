package com.tobeto.a.spring.intro.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;



@Table(name = "rentals")
@Entity
@Getter
@Setter
public class Rental
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "return_date")
    private LocalDate returnDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "start_kilometer")
    private int startKilometer;

    @Column(name = "end_kilometer")
    private int endKilometer;

    @Column(name = "total_price")
    private double totalPrice;



    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

}
