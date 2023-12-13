package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.Rental;
import com.tobeto.a.spring.intro.services.dtos.rental.response.GetListRentalResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Integer>{
    @Query("SELECT new com.tobeto.a.spring.intro.services.dtos.rental.response.GetListRentalResponse(r.returnDate,r.endDate,r.startDate) FROM Rental r WHERE r.returnDate > :returnDate")
    List<GetListRentalResponse> findByStartDateAfter(@Param("returnDate") LocalDate returnDate);
}


