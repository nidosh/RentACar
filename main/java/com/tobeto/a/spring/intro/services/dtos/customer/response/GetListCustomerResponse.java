package com.tobeto.a.spring.intro.services.dtos.customer.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetListCustomerResponse {
    private String firstName;
    private String lastName;
}
