package com.tobeto.a.spring.intro.controller;

import com.tobeto.a.spring.intro.entities.Car;
import com.tobeto.a.spring.intro.repositories.CarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CarController
{
    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAll(){
        return carRepository.findAll();
    }

    @GetMapping("{id}")
    public Car getAll(@PathVariable int id){
        return carRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Car car){
        carRepository.save(car);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Car carToDelete = carRepository.findById(id).orElseThrow();
        carRepository.delete(carToDelete);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Car car){
        Car carToUpdate = carRepository.findById(id).orElseThrow();
        carToUpdate.setModels(car.getModels());
        carToUpdate.setBrands(car.getBrands());
        carToUpdate.setYear(car.getYear());
        carToUpdate.setLicenseNumber(car.getLicenseNumber());
        carRepository.save(carToUpdate);
    }
}
