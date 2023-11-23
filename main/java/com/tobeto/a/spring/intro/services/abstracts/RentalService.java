package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.services.dtos.rental.request.AddRentalRequest;
import com.tobeto.a.spring.intro.services.dtos.rental.request.DeleteRentalRequest;
import com.tobeto.a.spring.intro.services.dtos.rental.request.UpdateRentalRequest;

public interface RentalService {
    void add(AddRentalRequest request);

    void delete(DeleteRentalRequest request);

    void update(UpdateRentalRequest request);
}
