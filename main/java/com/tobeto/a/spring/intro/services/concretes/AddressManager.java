package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.Address;
import com.tobeto.a.spring.intro.repositories.AddressRepository;
import com.tobeto.a.spring.intro.services.abstracts.AddressService;
import com.tobeto.a.spring.intro.services.dtos.address.request.AddAddressRequest;
import com.tobeto.a.spring.intro.services.dtos.address.request.DeleteAddressRequest;
import com.tobeto.a.spring.intro.services.dtos.address.request.UpdateAddressRequest;
import com.tobeto.a.spring.intro.services.dtos.address.response.GetListAddressResponse;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AddressManager implements AddressService {
    private AddressRepository addressRepository;

    public AddressManager(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public void add(AddAddressRequest request){
        Address address =  new Address();
        address.setCityName(request.getCityName());
        address.setCountryName(request.getCountryName());
        addressRepository.save(address);
    }

    @Override
    public void delete(DeleteAddressRequest request){
        Address addressToDelete = addressRepository.findById(request.getAddressId()).orElseThrow();
        addressRepository.save(addressToDelete);
    }

    @Override
    public void update(UpdateAddressRequest request) {
        Address addressToUpdate = addressRepository.findById(request.getAddressId()).orElseThrow();
        addressToUpdate.setCountryName(request.getCountryName());
        addressToUpdate.setCityName(request.getCityName());
        addressRepository.save(addressToUpdate);
    }

    @Override
    public List<GetListAddressResponse> getByCountryNameDto(String countryName) {
        return addressRepository.findByCountryName(countryName).
                stream()
                .map((Address) -> new GetListAddressResponse(Address.getCountryName()))
                .toList();
    }
}
