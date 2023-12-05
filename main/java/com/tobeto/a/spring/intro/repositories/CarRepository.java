package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.Car;
import com.tobeto.a.spring.intro.services.dtos.car.response.GetListCarResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer> {

    @Query("Select new com.tobeto.a.spring.intro.services.dtos.car.response.GetListCarResponse(c.models) From Car c Where c.models=:models")
    List<GetListCarResponse> findByModels(@Param("models") String models);

    @Query("Select new com.tobeto.a.spring.intro.services.dtos.car.response.GetListCarResponse(c.brands) From Car c Where c.brands=:brands")
    List<GetListCarResponse>findByBrans(@Param("brands") String brands);

    @Query("Select new com.tobeto.a.spring.intro.services.dtos.car.response.GetListCarResponse(c.models,c.brands," +
            " new com.tobeto.a.spring.intro.services.dtos.statu.response.GetListStatuResponse(s.name))" +
            " From Car c" +
            " INNER JOIN c.status s")
    List<GetListCarResponse> getAll();
}
