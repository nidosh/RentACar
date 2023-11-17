package com.tobeto.a.spring.intro.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

// ORM => Object Relation Mapping
@Table(name = "cars") //databasedeki cars tablosunun konfigürasyonu
@Entity
public class Car
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id") //name =  kolon adı
    private int carId; //classın içindeki alanın adı

    @Column(name="brands")
    private String marka;

    @Column(name = "models")
    private String models;

    @Column(name = "year")
    private int yıl;

    @Column(name = "license_number")
    private String licenseNumber;

    @Column(name = "daily_price")
    private double dailyPrice;

    @Column(name = "weekly_price")
    private double weeklyPrice;

    //TODO=> ilişkisel status tablosunun alanlarını eklemek

    @ManyToOne
    @JoinColumn(name = "status_id")
    //tekil ise join column eklemem gerekli.
    private Statu status;

    //one to many
    //customers
    @OneToMany(mappedBy = "cars")
    private List<Customer> customers;
}
