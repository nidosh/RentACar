package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.services.dtos.address.request.AddAddressRequest;
import com.tobeto.a.spring.intro.services.dtos.address.request.DeleteAddressRequest;
import com.tobeto.a.spring.intro.services.dtos.address.request.UpdateAddressRequest;

public interface AddressService {
    void add(AddAddressRequest request);

    void delete(DeleteAddressRequest request);

    void update(UpdateAddressRequest request);
}
