package com.tobeto.a.spring.intro.services.dtos.car.request;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarRequest {

    @Min(value=2005,message = "Model yılı en az 2005 olabilir!")
    private int year;

    @NotBlank(message = "Boş bırakılamaz! Lütfen geçerli bir plaka giriniz.")
    @Length(min = 6)
    private String licenseNumber;

}
