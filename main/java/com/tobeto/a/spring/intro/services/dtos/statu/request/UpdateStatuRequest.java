package com.tobeto.a.spring.intro.services.dtos.statu.request;

import lombok.Data;

@Data
public class UpdateStatuRequest
{
    private String carStatus;
    private int statuId;
}
