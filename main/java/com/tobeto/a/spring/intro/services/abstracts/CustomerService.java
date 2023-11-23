package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.services.dtos.customer.request.AddCustomerRequest;
import com.tobeto.a.spring.intro.services.dtos.customer.request.DeleteCustomerRequest;
import com.tobeto.a.spring.intro.services.dtos.customer.request.UpdateCustomerRequest;

public interface CustomerService {
    void add(AddCustomerRequest request);
    void delete(DeleteCustomerRequest request);
    void update(UpdateCustomerRequest request);
}
