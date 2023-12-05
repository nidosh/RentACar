package com.tobeto.a.spring.intro.services.dtos.customer.response;


import com.tobeto.a.spring.intro.services.dtos.address.response.GetListAddressResponse;
import com.tobeto.a.spring.intro.services.dtos.car.response.GetListCarResponse;
import com.tobeto.a.spring.intro.services.dtos.payment.response.GetListPaymentResponse;
import com.tobeto.a.spring.intro.services.dtos.rental.response.GetListRentalResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetListCustomerResponse {
    private String firstName;
    private String lastName;
    private GetListCarResponse cars;
    private GetListRentalResponse rentals;
    //private Car car; // entityleri dışarı açma!
    //private String brands;
    //private String models;
    //private int carId;
}
