package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.Rental;
import com.tobeto.a.spring.intro.services.dtos.rental.response.GetListRentalResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Integer>
{


    @Query("SELECT new com.tobeto.a.spring.intro.services.dtos.rental.response.GetListRentalResponse(r.rentalDate,r.endDate) FROM Rental r WHERE r.rentalDate > :rentalDate")
    List<GetListRentalResponse> findByStartDateAfter(@Param("rentalDate") String rentalDate);

}
