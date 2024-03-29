package com.tobeto.a.spring.intro.controller;


import com.tobeto.a.spring.intro.services.abstracts.AddressService;
import com.tobeto.a.spring.intro.services.dtos.address.request.AddAddressRequest;
import com.tobeto.a.spring.intro.services.dtos.address.request.DeleteAddressRequest;
import com.tobeto.a.spring.intro.services.dtos.address.request.UpdateAddressRequest;
import com.tobeto.a.spring.intro.services.dtos.address.response.GetListAddressResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/address")
@AllArgsConstructor
public class AddressController
{
    private AddressService addressService;

    @PostMapping
    public void add(@RequestBody @Valid AddAddressRequest request){
        addressService.add(request);
    }

    @DeleteMapping
    public void delete(@PathVariable @Valid DeleteAddressRequest request){
        addressService.delete(request);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateAddressRequest request){
        addressService.update(request);
    }
}
