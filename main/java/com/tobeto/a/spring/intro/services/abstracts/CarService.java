package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.services.dtos.car.request.AddCarRequest;
import com.tobeto.a.spring.intro.services.dtos.car.request.DeleteCarRequest;
import com.tobeto.a.spring.intro.services.dtos.car.request.UpdateCarRequest;
import com.tobeto.a.spring.intro.services.dtos.car.response.GetListCarResponse;
import org.springframework.stereotype.Service;


import java.util.List;



public interface CarService {
    void add(AddCarRequest request);
    void delete(DeleteCarRequest request);
    void update(UpdateCarRequest request);

    List<GetListCarResponse>getAll();


}
