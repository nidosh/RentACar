package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.concretes.Car;
import com.tobeto.a.spring.intro.repositories.CarRepository;
import com.tobeto.a.spring.intro.services.abstracts.CarService;
import com.tobeto.a.spring.intro.services.abstracts.StatuService;
import com.tobeto.a.spring.intro.services.dtos.car.request.AddCarRequest;
import com.tobeto.a.spring.intro.services.dtos.car.request.DeleteCarRequest;
import com.tobeto.a.spring.intro.services.dtos.car.request.UpdateCarRequest;
import com.tobeto.a.spring.intro.services.dtos.car.response.GetListCarResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Data
public class CarManager implements CarService {
    private CarRepository carRepository;


    private final StatuService statuService;

    // Her manager, yalnızca kendi entitysi için repository implementasyonu yapabilir!
    // Farklı bir entity ile çalışma gereğinde, o entitynin service'i ile çalışmalıdır.

    @Override
    public void add(AddCarRequest request){
        //mapleme
        //bussiness rule

        if(carRepository.existsCarByLicenseNumber(request.getLicenseNumber())){
            throw new RuntimeException("Aynı plakaya sahip ikinci araç eklenemez!");
        }
        Car car = new Car();
        car.setYear(request.getYear());
        car.setLicenseNumber(request.getLicenseNumber());
        // FK alanlar => FK alıp, veritabanından ilgili objeyi alarak set ederiz.
        carRepository.save(car);
    }

    @Override
    public void delete(DeleteCarRequest request){
        Car carToDelete = carRepository.findById(request.getId()).orElseThrow();
        carRepository.delete(carToDelete);
    }

    @Override
    public void update(UpdateCarRequest request){
        Car carToUpdate = carRepository.findById(request.getId()).orElseThrow();
        carToUpdate.setLicenseNumber(request.getLicenseNumber());
        carToUpdate.setYear(request.getYear());
        carRepository.save(carToUpdate);
    }


}
