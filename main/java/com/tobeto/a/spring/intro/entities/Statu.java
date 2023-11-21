package com.tobeto.a.spring.intro.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name = "status")
@Entity
@Getter
@Setter
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
    @JsonIgnore //sonsuz döngüden kaçınmak amacıyla listeleri JSON'da göstermiyoruz.
    private List<Car> cars;
}
