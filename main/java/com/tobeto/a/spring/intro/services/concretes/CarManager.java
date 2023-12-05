package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.Car;
import com.tobeto.a.spring.intro.repositories.CarRepository;
import com.tobeto.a.spring.intro.services.abstracts.CarService;
import com.tobeto.a.spring.intro.services.dtos.car.request.AddCarRequest;
import com.tobeto.a.spring.intro.services.dtos.car.request.DeleteCarRequest;
import com.tobeto.a.spring.intro.services.dtos.car.request.UpdateCarRequest;
import com.tobeto.a.spring.intro.services.dtos.car.response.GetListCarResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarManager implements CarService {
    private CarRepository carRepository;

    public CarManager(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void add(AddCarRequest request){
        Car car = new Car();
        car.setBrands(request.getBrand());
        car.setModels(request.getModel());
        car.setYear(request.getYear());
        car.setLicenseNumber(request.getLicenseNumber());
        carRepository.save(car);
    }

    @Override
    public void delete(DeleteCarRequest request){
        Car carToDelete = carRepository.findById(request.getCarId()).orElseThrow();
        carRepository.delete(carToDelete);
    }

    @Override
    public void update(UpdateCarRequest request){
        Car carToUpdate = carRepository.findById(request.getCarId()).orElseThrow();
        carToUpdate.setLicenseNumber(request.getLicenseNumber());
        carToUpdate.setBrands(request.getBrand());
        carToUpdate.setModels(request.getModel());
        carToUpdate.setYear(request.getYear());
        carRepository.save(carToUpdate);
    }

    @Override
    public List<GetListCarResponse> getByModelsNameDto(String models) {
        return carRepository.findByModels(models);
    }

    @Override
    public List<GetListCarResponse> getByBrandsNameDto(String brands) {
        return carRepository.findByModels(brands);
    }

    @Override
    public List<GetListCarResponse> getAll() {
        return carRepository.getAll()
                .stream()
                .map((Car) ->new GetListCarResponse(Car.getModels(), Car.getBrands(),Car.getStatus()))
                .toList();
    }

}
