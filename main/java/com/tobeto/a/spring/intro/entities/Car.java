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
    @Column(name = "id") //name =  kolon adı
    private Integer id; //classın içindeki alanın adı

    @Column(name = "year")
    private Integer year;

    @Column(name = "license_number")
    private String licenseNumber;


    //TODO=> ilişkisel status tablosunun alanlarını eklemek

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    @OneToMany(mappedBy = "car")
    @JsonIgnore
    List<Rental>rentals;

    @OneToMany(mappedBy = "car")
    @JsonIgnore
    List<Statu>status;

}
