package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.repositories.PaymentRepository;
import com.tobeto.a.spring.intro.services.dtos.payment.request.AddPaymentRequest;
import com.tobeto.a.spring.intro.services.dtos.payment.request.DeletePaymentRequest;
import com.tobeto.a.spring.intro.services.dtos.payment.request.UpdatePaymentRequest;

public interface PaymentService {
    void add(AddPaymentRequest request);

    void delete(DeletePaymentRequest request);

    void update(UpdatePaymentRequest request);
}
