package com.tobeto.a.spring.intro.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tobeto.a.spring.intro.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "brands")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Brand extends BaseEntity {

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "brand")
    @JsonIgnore
    List<Model>models;
}
