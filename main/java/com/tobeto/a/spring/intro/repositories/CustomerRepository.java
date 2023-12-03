package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.Customer;
import com.tobeto.a.spring.intro.services.dtos.customer.response.GetListCustomerResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer>
{
    @Query("Select new com.tobeto.a.spring.intro.services.dtos.customer.response.GetListCustomerResponse(cu.firstName,cu.lastName) From Customer cu Where cu.firstName=:firstName and cu.lastName=:lastName")
    List<GetListCustomerResponse> findByFirstAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);
}
