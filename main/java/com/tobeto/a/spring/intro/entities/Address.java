package com.tobeto.a.spring.intro.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name = "address")
@Entity
@Getter
@Setter

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private int addressId;

    @Column(name ="city")
    private String cityName;

    @Column(name = "country")
    private String countryName;

    @OneToMany(mappedBy = "address")
    @JsonIgnore
    private List<Customer> customers;
}
