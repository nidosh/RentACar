package com.tobeto.a.spring.intro.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Table(name = "customers")
@Entity
@Getter
@Setter
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "card_number")
    private int cardNumber;

    @Column(name = "phone_number")
    private int phoneNumber;

    @Column(name = "birth_date")
    private LocalDate birth_date;


    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    List<Rental>rentals;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

}
