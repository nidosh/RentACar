package com.tobeto.a.spring.intro.services.dtos.address.request;

import lombok.Data;

@Data
public class AddAddressRequest {
    private String cityName;
    private String countryName;
}
