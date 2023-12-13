package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.Statu;
import com.tobeto.a.spring.intro.services.dtos.statu.response.GetListStatuResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//Generic
//Generic Typlar Referance Type olarak belirtilmelidir.
@Repository
public interface StatuRepository extends JpaRepository<Statu, Integer>
{
    List<Statu>findByNameStartingWith(String name);
    @Query("Select new com.tobeto.a.spring.intro.services.dtos.statu.response.GetListStatuResponse(s.name,s.id) " +
            "From Statu s Where s.name=:name")
    List<GetListStatuResponse> findByName(String name);
}

