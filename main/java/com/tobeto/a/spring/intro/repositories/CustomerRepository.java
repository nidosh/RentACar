package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.Customer;
import com.tobeto.a.spring.intro.services.dtos.customer.response.GetListCustomerResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>
{
    @Query("Select new com.tobeto.a.spring.intro.services.dtos.customer.response.GetListCustomerResponse(cu.firstName,cu.lastName)" +
            " From Customer cu Where cu.firstName=:firstName and cu.lastName=:lastName")
    List<GetListCustomerResponse> findByFirstAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query("Select new com.tobeto.a.spring.intro.services.dtos.customer.response.GetListCustomerResponse(cu.firstName,cu.lastName,new com.tobeto.a.spring.intro.services.dtos.rental.response.GetListRentalResponse(r.returnDate,r.endDate)) From Customer cu INNER JOIN cu.rentals r Where r.returnDate Between '2023-01-01' And '2024-01-01'")
    List<GetListCustomerResponse> getAll();
}
