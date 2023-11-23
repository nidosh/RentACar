package com.tobeto.a.spring.intro.services.dtos.customer.request;

import lombok.Data;

@Data
public class AddCustomerRequest {
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private int cardNumber;
}
