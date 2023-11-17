package com.tobeto.a.spring.intro.entities;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "status")
@Entity
public class Statu
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private int statusId;

    @Column(name = "car_status")
    private String carStatus;


    //one-to-one ilişkilerde list olan değişken
    //@onetomany
    //direkt class olan değişken @manytoone
    @OneToMany(mappedBy = "status") //Car classımda atadığım değişken ismi
    private List<Car> cars;
}
