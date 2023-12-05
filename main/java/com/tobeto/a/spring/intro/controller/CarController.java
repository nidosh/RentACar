package com.tobeto.a.spring.intro.controller;

import com.tobeto.a.spring.intro.services.abstracts.CarService;
import com.tobeto.a.spring.intro.services.dtos.car.request.AddCarRequest;
import com.tobeto.a.spring.intro.services.dtos.car.request.DeleteCarRequest;
import com.tobeto.a.spring.intro.services.dtos.car.request.UpdateCarRequest;
import com.tobeto.a.spring.intro.services.dtos.car.response.GetListCarResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/car")
public class CarController
{
    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public void add(@RequestBody AddCarRequest request){
        carService.add(request);
    }

    @DeleteMapping
    public void delete(@PathVariable DeleteCarRequest request){
        carService.delete(request);
    }

    @PutMapping
    public void update(@RequestBody UpdateCarRequest request){
        carService.update(request);
    }

    @GetMapping("/api/car/dto/models")
    public List<GetListCarResponse>getByModelsNameDto(@RequestParam String models){
        return carService.getByModelsNameDto(models);
    }

    @GetMapping("/api/car/dto/brands")
    public List<GetListCarResponse>getByBrandsNameDto(@RequestParam String brands){
        return carService.getByBrandsNameDto(brands);
    }

    @GetMapping("getAll")
    public List<GetListCarResponse>getAll(){
        return carService.getAll();
    }

}
