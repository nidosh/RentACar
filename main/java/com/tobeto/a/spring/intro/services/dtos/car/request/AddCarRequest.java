package com.tobeto.a.spring.intro.services.dtos.car.request;

import lombok.Data;

@Data
public class AddCarRequest {
    private String brand;
    private String model;
    private int year;
    private String licenseNumber;
}
