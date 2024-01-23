package com.tobeto.a.spring.intro.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tobeto.a.spring.intro.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table(name = "models")
@Entity
@Data
public class Model extends BaseEntity {


    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "model")
    @JsonIgnore
    List<Car>cars;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
}
