package com.tobeto.a.spring.intro.services.dtos.rental.request;

import lombok.Data;

@Data
public class AddRentalRequest {
    private String rentalDate;
    private String endDate;
}
