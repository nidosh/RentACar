package com.tobeto.a.spring.intro.services.dtos.payment.request;

import lombok.Data;

@Data
public class UpdatePaymentRequest {
    private int paymentId;
    private boolean card;
    private boolean cash;
    private double dailyPrice;
    private double weeklyPrice;
}
