package com.tobeto.a.spring.intro.entities;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "rentals")
@Entity
public class Rental
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id")
    private int rentalId;

    @Column(name = "rental_date")
    private String rentalDate;

    @Column(name = "end_date")
    private String endDate;

    //onetomany
    //customers
    @OneToMany(mappedBy = "rentals")
    private List<Customer> customers;
}
