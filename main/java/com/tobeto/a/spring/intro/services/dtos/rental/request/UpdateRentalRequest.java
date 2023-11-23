package com.tobeto.a.spring.intro.services.dtos.rental.request;

import lombok.Data;

@Data
public class UpdateRentalRequest {
    private int rentalId;
    private String rentalDate;
    private String endDate;

}
