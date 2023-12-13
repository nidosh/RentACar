package com.tobeto.a.spring.intro.services.dtos.customer.response;


import com.tobeto.a.spring.intro.services.dtos.rental.response.GetListRentalResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetListCustomerResponse {
    private String firstName;
    private String lastName;
    private List<GetListRentalResponse> rentals;
    private LocalDate birth_date;
    //private Car car; // entityleri dışarı açma!
}
