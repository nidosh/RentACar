package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.PaymentMethods;
import com.tobeto.a.spring.intro.services.dtos.payment.response.GetListPaymentResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentRepository extends JpaRepository<PaymentMethods,Integer>
{
    @Query("Select new com.tobeto.a.spring.intro.services.dtos.payment.response.GetListPaymentResponse(p.dailyPrice,p.weeklyPrice) From PaymentMethods p Where p.dailyPrice=dailyPrice and p.weeklyPrice=weeklyPrice")
    List<GetListPaymentResponse> findByDailyAndWeeklyPrice(double dailyPrice, double weeklyPrice);
}
