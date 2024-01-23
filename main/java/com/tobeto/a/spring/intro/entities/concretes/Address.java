package com.tobeto.a.spring.intro.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tobeto.a.spring.intro.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name = "address")
@Entity
@Getter
@Setter
public class Address extends BaseEntity {
    @Column(name ="city")
    private String cityName;

    @Column(name = "country")
    private String countryName;

    @OneToMany(mappedBy = "address")
    @JsonIgnore
    private List<Customer> customers;
}
