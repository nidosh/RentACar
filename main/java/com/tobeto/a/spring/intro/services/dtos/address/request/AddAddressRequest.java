package com.tobeto.a.spring.intro.services.dtos.address.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddAddressRequest {
    @NotBlank(message = "Bu alan boş bırakılamaz! Lütfen geçerli bir şehir ismi giriniz.")
    private String cityName;

    @NotBlank(message = "Bu alan boş bırakılamaz! Lütfen geçerli bir ülke ismi giriniz.")
    private String countryName;
}
