package com.tobeto.a.spring.intro.services.dtos.statu.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddStatuRequest {
    @NotBlank(message = "Lütfen geçerli bir isim giriniz!")
    private String name;
}
