package com.tobeto.a.spring.intro.controller;

import com.tobeto.a.spring.intro.entities.Address;
import com.tobeto.a.spring.intro.repositories.AddressRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class AddressController
{
    private final AddressRepository addressRepository;

    public AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAll(){
        return addressRepository.findAll();
    }

    @GetMapping("{id}")
    public Address getAll(@PathVariable int id){
        return addressRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Address address){
        addressRepository.save(address);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Address addresstoDelete = addressRepository.findById(id).orElseThrow();
        addressRepository.delete(addresstoDelete);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Address address){
        Address addressToUpdate = addressRepository.findById(id).orElseThrow();
        addressToUpdate.setCityName(address.getCityName());
        addressToUpdate.setCountryName(address.getCountryName());
        addressRepository.save(addressToUpdate);
    }
}
