package com.tobeto.a.spring.intro.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name = "rentals")
@Entity
@Getter
@Setter
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
    @JsonIgnore
    private List<Customer> customers;
}