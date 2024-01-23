package com.tobeto.a.spring.intro.entities.abstracts;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@MappedSuperclass
@Data
public abstract class BaseEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /*classlar eklenmeden önce çalışacak metottur.
    @PrePersist
    private void beforeAdd(){
        createdDate= LocalDate.now();
    }

    @PreUpdate
    private void beforeUpdate(){
        updateDate=LocalDate.now();
    }*/
}
