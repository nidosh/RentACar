package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.Car;
import com.tobeto.a.spring.intro.services.dtos.car.response.GetListCarResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {

    boolean existsCarByLicenseNumber(String licenseNumber);

    @Query("Select new com.tobeto.a.spring.intro.services.dtos.car.response.GetListCarResponse(c.year,c.licenseNumber) From Car c")
    List<GetListCarResponse> getAll();
}
