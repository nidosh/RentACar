package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.Customer;
import com.tobeto.a.spring.intro.repositories.CustomerRepository;
import com.tobeto.a.spring.intro.services.abstracts.CustomerService;
import com.tobeto.a.spring.intro.services.dtos.customer.request.AddCustomerRequest;
import com.tobeto.a.spring.intro.services.dtos.customer.request.DeleteCustomerRequest;
import com.tobeto.a.spring.intro.services.dtos.customer.request.UpdateCustomerRequest;
import com.tobeto.a.spring.intro.services.dtos.customer.response.GetListCustomerResponse;
import org.hibernate.annotations.SecondaryRow;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerManager implements CustomerService
{
    private CustomerRepository customerRepository;

    public CustomerManager(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void add(AddCustomerRequest request){
        Customer customer = new Customer();
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setPhoneNumber(request.getPhoneNumber());
        customer.setCardNumber(request.getCardNumber());
        customerRepository.save(customer);
    }

    @Override
    public void delete(DeleteCustomerRequest request){
        Customer customerToDelete = customerRepository.findById(request.getCustomerId()).orElseThrow();
        customerRepository.delete(customerToDelete);
    }

    @Override
    public void update(UpdateCustomerRequest request){
        Customer customerToUpdate = customerRepository.findById(request.getCustomerId()).orElseThrow();
        customerToUpdate.setFirstName(request.getFirstName());
        customerToUpdate.setLastName(request.getLastName());
        customerToUpdate.setPhoneNumber(request.getPhoneNumber());
        customerToUpdate.setCardNumber(request.getCardNumber());
    }

    @Override
    public List<GetListCustomerResponse> getByFirstAndLastNameDto(String firstName, String lastName) {
        return customerRepository.findByFirstAndLastName(firstName,lastName);
    }
}
