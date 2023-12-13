package com.tobeto.a.spring.intro.services.dtos.rental.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDate;

@Data
public class AddRentalRequest {

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate returnDate;


    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate endDate;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate startDate;

}
