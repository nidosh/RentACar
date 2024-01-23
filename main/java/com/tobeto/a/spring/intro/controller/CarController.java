package com.tobeto.a.spring.intro.controller;

import com.tobeto.a.spring.intro.services.abstracts.CarService;
import com.tobeto.a.spring.intro.services.concretes.CarManager;
import com.tobeto.a.spring.intro.services.dtos.car.request.AddCarRequest;
import com.tobeto.a.spring.intro.services.dtos.car.request.DeleteCarRequest;
import com.tobeto.a.spring.intro.services.dtos.car.request.UpdateCarRequest;
import com.tobeto.a.spring.intro.services.dtos.car.response.GetListCarResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/car")
@Data
@AllArgsConstructor
public class CarController
{
    private CarService carService;
    private CarManager carManager;

    @PostMapping
    public void add(@RequestBody @Valid AddCarRequest request){
        carService.add(request);
    }

    @DeleteMapping
    public void delete(@PathVariable @Valid DeleteCarRequest request){
        carService.delete(request);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateCarRequest request){
        carService.update(request);
    }



}
