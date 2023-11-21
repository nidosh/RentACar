package com.tobeto.a.spring.intro.controller;

import com.tobeto.a.spring.intro.entities.PaymentMethods;
import com.tobeto.a.spring.intro.repositories.PaymentRepository;
import org.springframework.web.bind.annotation.*;


import java.util.List;

public class PaymentController
{
    private PaymentRepository paymentRepository;

    public PaymentController(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<PaymentMethods> getAll(){
        return paymentRepository.findAll();
    }

    @GetMapping("{id}")
        public PaymentMethods getAll(@PathVariable int id){
            return paymentRepository.findById(id).orElseThrow();
        }

    @PostMapping
    public void add(@RequestBody PaymentMethods paymentMethods){
        paymentRepository.save(paymentMethods);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        PaymentMethods paymentToDelete = paymentRepository.findById(id).orElseThrow();
        paymentRepository.delete(paymentToDelete);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody PaymentMethods paymentMethods){
        PaymentMethods paymentToUpdate = paymentRepository.findById(id).orElseThrow();
        paymentToUpdate.setDailyPrice(paymentToUpdate.getDailyPrice());
        paymentToUpdate.setWeeklyPrice(paymentToUpdate.getWeeklyPrice());
        paymentToUpdate.setCard(paymentToUpdate.isCard());
        paymentToUpdate.setCash(paymentToUpdate.isCash());
        paymentRepository.save(paymentToUpdate);
    }
}


