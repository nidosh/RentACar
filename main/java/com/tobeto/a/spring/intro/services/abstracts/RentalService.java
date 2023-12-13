package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.entities.Rental;
import com.tobeto.a.spring.intro.services.dtos.rental.request.AddRentalRequest;
import com.tobeto.a.spring.intro.services.dtos.rental.request.DeleteRentalRequest;
import com.tobeto.a.spring.intro.services.dtos.rental.request.UpdateRentalRequest;
import com.tobeto.a.spring.intro.services.dtos.rental.response.GetListRentalResponse;

import java.time.LocalDate;
import java.util.List;

public interface RentalService {
    void add(AddRentalRequest request);

    void delete(DeleteRentalRequest request);

    void update(UpdateRentalRequest request);

    List<GetListRentalResponse> getByReturnDateDto();

    List<GetListRentalResponse> getByReturnDateDto(String rentalDate);

    List<GetListRentalResponse> getByReturnDateDto(LocalDate rentalDate);
}
