package com.tobeto.a.spring.intro.services.dtos.car.request;

import lombok.Data;

@Data
public class UpdateCarRequest {
    private int carId;
    private String brand;
    private String model;
    private int year;
    private String licenseNumber;
}
