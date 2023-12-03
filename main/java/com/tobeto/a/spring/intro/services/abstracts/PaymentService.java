package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.services.dtos.payment.request.AddPaymentRequest;
import com.tobeto.a.spring.intro.services.dtos.payment.request.DeletePaymentRequest;
import com.tobeto.a.spring.intro.services.dtos.payment.request.UpdatePaymentRequest;
import com.tobeto.a.spring.intro.services.dtos.payment.response.GetListPaymentResponse;

import java.util.List;

public interface PaymentService {
    void add(AddPaymentRequest request);

    void delete(DeletePaymentRequest request);

    void update(UpdatePaymentRequest request);
    List<GetListPaymentResponse>getByDailyAndWeeklyPriceDto(double dailyPrice, double weeklyPrice);
}
