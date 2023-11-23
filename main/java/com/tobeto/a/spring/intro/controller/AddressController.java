package com.tobeto.a.spring.intro.controller;


import com.tobeto.a.spring.intro.services.abstracts.AddressService;
import com.tobeto.a.spring.intro.services.dtos.address.request.AddAddressRequest;
import com.tobeto.a.spring.intro.services.dtos.address.request.DeleteAddressRequest;
import com.tobeto.a.spring.intro.services.dtos.address.request.UpdateAddressRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/address")
public class AddressController
{
    private AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public void add(@RequestBody AddAddressRequest request){
        addressService.add(request);
    }

    @DeleteMapping
    public void delete(@PathVariable DeleteAddressRequest request){
        addressService.delete(request);
    }

    @PutMapping
    public void update(@RequestBody UpdateAddressRequest request){
        addressService.update(request);
    }
}
