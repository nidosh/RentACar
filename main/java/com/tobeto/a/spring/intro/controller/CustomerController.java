package com.tobeto.a.spring.intro.controller;

import com.tobeto.a.spring.intro.entities.Customer;
import com.tobeto.a.spring.intro.repositories.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CustomerController
{
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    @GetMapping("{id}")
    public Customer getAll(@PathVariable int id){
        return customerRepository.findById(id).orElseThrow();
    }
    @PostMapping
    public void add(@RequestBody Customer customer){
        customerRepository.save(customer);
    }

    @DeleteMapping
    public void delete(@PathVariable int id){
        Customer customerToDelete =  customerRepository.findById(id).orElseThrow();
        customerRepository.delete(customerToDelete);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Customer customer){
        Customer customerToUpdate = customerRepository.findById(id).orElseThrow();
        customerToUpdate.setFirstName(customer.getFirstName());
        customerToUpdate.setLastName(customer.getLastName());
        customerToUpdate.setCardNumber(customer.getCardNumber());
        customerToUpdate.setPhoneNumber(customer.getPhoneNumber());
        customerRepository.save(customerToUpdate);
    }
}
