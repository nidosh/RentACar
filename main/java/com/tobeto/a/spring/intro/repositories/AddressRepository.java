package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.Address;
import com.tobeto.a.spring.intro.services.dtos.address.response.GetListAddressResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Integer>
{
    @Query("Select new com.tobeto.a.spring.intro.services.dtos.address.response.GetListAddressResponse(a.countryName) From Address a Where a.countryName=:countryName")
    List<GetListAddressResponse> findByCountryName(@Param("countryName") String countryName);
}
