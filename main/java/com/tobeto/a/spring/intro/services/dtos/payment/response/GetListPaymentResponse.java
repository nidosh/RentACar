package com.tobeto.a.spring.intro.services.dtos.payment.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListPaymentResponse {
    private double dailyPrice;
    private double weeklyPrice;
}
