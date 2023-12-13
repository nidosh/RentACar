package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.Customer;
import com.tobeto.a.spring.intro.repositories.CustomerRepository;
import com.tobeto.a.spring.intro.services.abstracts.CustomerService;
import com.tobeto.a.spring.intro.services.dtos.customer.request.AddCustomerRequest;
import com.tobeto.a.spring.intro.services.dtos.customer.request.DeleteCustomerRequest;
import com.tobeto.a.spring.intro.services.dtos.customer.request.UpdateCustomerRequest;
import com.tobeto.a.spring.intro.services.dtos.customer.response.GetListCustomerResponse;
import com.tobeto.a.spring.intro.services.dtos.rental.response.GetListRentalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;

@Service
public class CustomerManager implements CustomerService
{
    @Autowired
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
        customer.setBirth_date(request.getBirth_date());
        customerRepository.save(customer);
    }

    @Override
    public void delete(DeleteCustomerRequest request){
        Customer customerToDelete = customerRepository.findById(request.getId()).orElseThrow();
        customerRepository.delete(customerToDelete);
    }

    @Override
    public void update(UpdateCustomerRequest request){
        Customer customerToUpdate = customerRepository.findById(request.getId()).orElseThrow();
        customerToUpdate.setFirstName(request.getFirstName());
        customerToUpdate.setLastName(request.getLastName());
        customerToUpdate.setPhoneNumber(request.getPhoneNumber());
        customerToUpdate.setCardNumber(request.getCardNumber());
        customerToUpdate.setBirth_date(request.getBirth_date());
    }

    @Override
    public List<GetListCustomerResponse> getByFirstAndLastNameDto(String firstName, String lastName) {
        return customerRepository.findByFirstAndLastName(firstName,lastName);
    }

    @Override
    public List<GetListCustomerResponse> getAll() {
        return customerRepository.getAll()
                .stream()
                .map((Customer) -> new GetListCustomerResponse(
                        Customer.getFirstName(),
                        Customer.getLastName(),
                        Customer.getRentals().stream()
                        .map(Rental -> new GetListRentalResponse(Rental.getReturnDate(),Rental.getEndDate(),Rental.getStartDate()))
                        .collect(Collectors.toList()),
                        Customer.getBirth_date()))
                .toList();
    }


}
