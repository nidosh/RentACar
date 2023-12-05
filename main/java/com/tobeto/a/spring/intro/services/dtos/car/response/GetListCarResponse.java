package com.tobeto.a.spring.intro.services.dtos.car.response;

import com.tobeto.a.spring.intro.services.dtos.statu.response.GetListStatuResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetListCarResponse {
    private String models;
    private String brands;
    private GetListStatuResponse status;

}
