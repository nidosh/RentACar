package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.Model;
import com.tobeto.a.spring.intro.services.dtos.model.response.GetListModelResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Model,Integer> {
    @Query("Select new com.tobeto.a.spring.intro.services.dtos.model.response.GetListModelResponse(m.name) From Model m Where name = :name")
    List<GetListModelResponse> findByName(String name);
}


