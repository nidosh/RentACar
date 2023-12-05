package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.PaymentMethods;
import com.tobeto.a.spring.intro.repositories.PaymentRepository;
import com.tobeto.a.spring.intro.services.abstracts.PaymentService;
import com.tobeto.a.spring.intro.services.dtos.payment.request.AddPaymentRequest;
import com.tobeto.a.spring.intro.services.dtos.payment.request.DeletePaymentRequest;
import com.tobeto.a.spring.intro.services.dtos.payment.request.UpdatePaymentRequest;
import com.tobeto.a.spring.intro.services.dtos.payment.response.GetListPaymentResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentManager implements PaymentService {
    private PaymentRepository paymentRepository;

    public PaymentManager(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void add(AddPaymentRequest request){
        PaymentMethods paymentMethods = new PaymentMethods();
        paymentMethods.setCash(request.isCash());
        paymentMethods.setCard(request.isCard());
        paymentMethods.setDailyPrice(request.getDailyPrice());
        paymentMethods.setWeeklyPrice(request.getWeeklyPrice());
        paymentRepository.save(paymentMethods);
    }

    @Override
    public void delete(DeletePaymentRequest request) {
        PaymentMethods paymentMethodsToDelete = paymentRepository.findById(request.getPaymentId()).orElseThrow();
        paymentRepository.delete(paymentMethodsToDelete);
    }
    @Override
    public void update(UpdatePaymentRequest request) {
        PaymentMethods paymentMethodsToUpdate = paymentRepository.findById(request.getPaymentId()).orElseThrow();
        paymentMethodsToUpdate.setWeeklyPrice(request.getWeeklyPrice());
        paymentMethodsToUpdate.setDailyPrice(request.getDailyPrice());
        paymentMethodsToUpdate.setCash(request.isCash());
        paymentMethodsToUpdate.setCard(request.isCard());
        paymentRepository.save(paymentMethodsToUpdate);
    }

    @Override
    public List<GetListPaymentResponse> getByDailyAndWeeklyPriceDto(double dailyPrice, double weeklyPrice) {
        return paymentRepository.findByDailyAndWeeklyPrice(dailyPrice,weeklyPrice)
                .stream()
                .map((PaymentMethods) -> new GetListPaymentResponse(PaymentMethods.getDailyPrice(),PaymentMethods.getWeeklyPrice()))
                .filter(payment -> payment.getDailyPrice() > 4000)
                .toList();
    }
}
