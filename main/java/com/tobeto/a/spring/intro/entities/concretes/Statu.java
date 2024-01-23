package com.tobeto.a.spring.intro.entities.concretes;

import com.tobeto.a.spring.intro.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "status")
@Entity
@Getter
@Setter
public class Statu extends BaseEntity
{

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

}
