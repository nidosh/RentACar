package com.tobeto.a.spring.intro.entities.concretes;


import com.tobeto.a.spring.intro.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;



@Table(name = "rentals")
@Entity
@Getter
@Setter
public class Rental extends BaseEntity
{

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
