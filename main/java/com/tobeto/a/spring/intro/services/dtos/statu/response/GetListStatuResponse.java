package com.tobeto.a.spring.intro.services.dtos.statu.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListStatuResponse {
    private String name;
    private int id;
}
