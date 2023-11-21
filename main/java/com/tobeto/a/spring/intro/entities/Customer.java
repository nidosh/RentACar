package com.tobeto.a.spring.intro.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "customers")
@Entity
@Getter
@Setter
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "card_number")
    private int cardNumber;

    @Column(name = "phone_number")
    private int phoneNumber;


    //Manytoone
    //rental
    @ManyToOne
    @JoinColumn(name = "rental_id")
    private Rental rentals;

    //car
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car cars;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private PaymentMethods paymentMethods;

}
