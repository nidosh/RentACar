package com.tobeto.a.spring.intro.services.dtos.customer.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDate;

@Data
public class UpdateCustomerRequest {
    private int id;

    @NotBlank(message = "Bu alan boş bırakılamaz! Lütfen geçerli bir isim giriniz.")
    private String firstName;

    @NotBlank(message = "Bu alan boş bırakılamaz! Lütfen geçerli bir soyisim giriniz.")
    private String lastName;

    @NotBlank
    @Length(max = 10,min = 10,message = "Lütfen başına 0 koymadan telefon numaranızı giriniz. ")
    private int phoneNumber;

    @NotBlank
    @CreditCardNumber
    private int cardNumber;

    @NotBlank
    @DateTimeFormat
    private LocalDate birth_date;
}
