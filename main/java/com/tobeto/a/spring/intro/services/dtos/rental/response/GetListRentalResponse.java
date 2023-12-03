package com.tobeto.a.spring.intro.services.dtos.rental.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListRentalResponse {
    private String rentalDate;
    private String endDate;
}
