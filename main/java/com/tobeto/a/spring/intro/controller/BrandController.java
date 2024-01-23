package com.tobeto.a.spring.intro.controller;

import com.tobeto.a.spring.intro.services.abstracts.BrandService;
import com.tobeto.a.spring.intro.services.dtos.brand.request.AddBrandRequest;
import com.tobeto.a.spring.intro.services.dtos.brand.request.DeleteBrandRequest;
import com.tobeto.a.spring.intro.services.dtos.brand.request.UpdateBrandRequest;
import com.tobeto.a.spring.intro.services.dtos.brand.response.GetListBrandResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brand")
@AllArgsConstructor
public class BrandController {
    public BrandService brandService;

    @PostMapping
    public void add(@RequestBody @Valid AddBrandRequest request){
        brandService.add(request);
    }

    @DeleteMapping
    public void delete(@PathVariable @Valid DeleteBrandRequest request){
        brandService.delete(request);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateBrandRequest request){
        brandService.update(request);
    }


}
