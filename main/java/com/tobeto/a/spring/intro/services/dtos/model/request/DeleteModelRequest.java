package com.tobeto.a.spring.intro.services.dtos.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DeleteModelRequest {
    private int id;

    @NotBlank(message = "Bu alan boş bırakılamaz! Lütfen geçerli bir model giriniz.")
    private String name;
}
