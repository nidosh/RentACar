package com.tobeto.a.spring.intro.services.dtos.car.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetListCarResponse {
    private int id;
    private String year;
    private String license_number;

}
