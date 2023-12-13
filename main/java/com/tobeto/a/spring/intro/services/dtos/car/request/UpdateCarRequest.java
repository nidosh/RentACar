package com.tobeto.a.spring.intro.services.dtos.car.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UpdateCarRequest {
    private int id;

    @NotBlank
    @Min(value = 2005,message = "Model yılı en az 2005 olabilir!")
    private int year;

    @NotBlank(message = "Boş bırakılamaz! Lütfen geçerli bir plaka giriniz.")
    @Length(min = 6)
    private String licenseNumber;
}
