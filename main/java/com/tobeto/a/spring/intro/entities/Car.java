package com.tobeto.a.spring.intro.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

//Repository, DAO, DAL
//Data Access Object
//Data Access Layer


// ORM => Object Relation Mapping
@Table(name = "cars") //databasedeki cars tablosunun konfigürasyonu
@Entity
@Getter
@Setter
public class Car
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id") //name =  kolon adı
    private int carId; //classın içindeki alanın adı

    @Column(name="brands")
    private String brands;

    @Column(name = "models")
    private String models;

    @Column(name = "year")
    private int year;

    @Column(name = "license_number")
    private String licenseNumber;


    //TODO=> ilişkisel status tablosunun alanlarını eklemek

    @ManyToOne
    @JoinColumn(name = "status_id")
    //tekil ise join column eklemem gerekli.
    private Statu status;

    //one to many
    //customers
    @OneToMany(mappedBy = "cars")
    @JsonIgnore
    private List<Customer> customers;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private PaymentMethods paymentMethods;
}
