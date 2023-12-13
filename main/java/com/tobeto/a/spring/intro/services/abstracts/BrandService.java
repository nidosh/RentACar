package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.services.dtos.brand.request.AddBrandRequest;
import com.tobeto.a.spring.intro.services.dtos.brand.request.DeleteBrandRequest;
import com.tobeto.a.spring.intro.services.dtos.brand.request.UpdateBrandRequest;
import com.tobeto.a.spring.intro.services.dtos.brand.response.GetListBrandResponse;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BrandService {
    void add(AddBrandRequest addBrandRequest);
    void delete(DeleteBrandRequest deleteBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);


    List<GetListBrandResponse> getByNameDto(String name);
}
