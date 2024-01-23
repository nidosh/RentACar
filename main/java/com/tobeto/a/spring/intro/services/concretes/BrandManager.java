package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.concretes.Brand;
import com.tobeto.a.spring.intro.repositories.BrandRepository;
import com.tobeto.a.spring.intro.services.abstracts.BrandService;
import com.tobeto.a.spring.intro.services.dtos.brand.request.AddBrandRequest;
import com.tobeto.a.spring.intro.services.dtos.brand.request.DeleteBrandRequest;
import com.tobeto.a.spring.intro.services.dtos.brand.request.UpdateBrandRequest;
import com.tobeto.a.spring.intro.services.dtos.brand.response.GetListBrandResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class BrandManager implements BrandService {
    @Autowired
    private BrandRepository brandRepository;


    @Override
    public void add(AddBrandRequest request) {
        Brand brand = new Brand();
        brand.setName(request.getName());
        brandRepository.save(brand);
    }

    @Override
    public void delete(DeleteBrandRequest request) {
        Brand brandToDelete = brandRepository.findById(request.getId()).orElseThrow();
        brandRepository.delete(brandToDelete);
    }

    @Override
    public void update(UpdateBrandRequest request) {
        Brand brandToUpdate = brandRepository.findById(request.getId()).orElseThrow();
        brandToUpdate.setId(request.getId());
        brandToUpdate.setName(request.getName());
        brandRepository.save(brandToUpdate);

    }
}
