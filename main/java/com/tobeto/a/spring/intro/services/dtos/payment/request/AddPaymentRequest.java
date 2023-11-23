package com.tobeto.a.spring.intro.services.dtos.payment.request;

import lombok.Data;

@Data
public class AddPaymentRequest {
    private boolean card;
    private boolean cash;
    private double dailyPrice;
    private double weeklyPrice;

}
