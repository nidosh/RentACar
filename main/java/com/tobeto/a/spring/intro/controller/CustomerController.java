package com.tobeto.a.spring.intro.controller;


import com.tobeto.a.spring.intro.services.abstracts.CustomerService;
import com.tobeto.a.spring.intro.services.dtos.customer.request.AddCustomerRequest;
import com.tobeto.a.spring.intro.services.dtos.customer.request.DeleteCustomerRequest;
import com.tobeto.a.spring.intro.services.dtos.customer.request.UpdateCustomerRequest;
import com.tobeto.a.spring.intro.services.dtos.customer.response.GetListCustomerResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customer")
public class CustomerController
{
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public void add(@RequestBody @Valid AddCustomerRequest request){
        customerService.add(request);
    }

    @DeleteMapping
    public void delete(@PathVariable @Valid DeleteCustomerRequest request){
        customerService.delete(request);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateCustomerRequest request){
        customerService.update(request);
    }

}
