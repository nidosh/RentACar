package com.tobeto.a.spring.intro.controller;

import com.tobeto.a.spring.intro.entities.PaymentMethods;
import com.tobeto.a.spring.intro.repositories.PaymentRepository;
import com.tobeto.a.spring.intro.services.abstracts.PaymentService;
import com.tobeto.a.spring.intro.services.dtos.address.request.UpdateAddressRequest;
import com.tobeto.a.spring.intro.services.dtos.payment.request.AddPaymentRequest;
import com.tobeto.a.spring.intro.services.dtos.payment.request.DeletePaymentRequest;
import com.tobeto.a.spring.intro.services.dtos.payment.request.UpdatePaymentRequest;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/payment")
public class PaymentController
{
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public void add(@RequestBody AddPaymentRequest request){
        paymentService.add(request);
    }

    @DeleteMapping
    public void delete(@PathVariable DeletePaymentRequest request){
        paymentService.delete(request);
    }

    @PutMapping
    public void update(@RequestBody UpdatePaymentRequest request){
        paymentService.update(request);
    }
}


