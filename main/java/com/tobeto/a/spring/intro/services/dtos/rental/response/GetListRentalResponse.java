package com.tobeto.a.spring.intro.services.dtos.rental.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListRentalResponse {
    private LocalDate returnDate;
    private LocalDate endDate;
    private LocalDate startDate;
}
