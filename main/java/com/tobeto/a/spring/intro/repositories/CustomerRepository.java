package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.concretes.Customer;
import com.tobeto.a.spring.intro.services.dtos.customer.response.GetListCustomerResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>
{
}
