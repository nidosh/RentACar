package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.concretes.Address;
import com.tobeto.a.spring.intro.services.dtos.address.response.GetListAddressResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer>
{

}
