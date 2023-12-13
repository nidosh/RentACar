package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.services.dtos.brand.response.GetListBrandResponse;
import com.tobeto.a.spring.intro.services.dtos.model.request.AddModelRequest;
import com.tobeto.a.spring.intro.services.dtos.model.request.DeleteModelRequest;
import com.tobeto.a.spring.intro.services.dtos.model.request.UpdateModelRequest;
import com.tobeto.a.spring.intro.services.dtos.model.response.GetListModelResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ModelService {
    void add(AddModelRequest request);
    void delete(DeleteModelRequest request);
    void update(UpdateModelRequest request);

    List<GetListModelResponse>getByNameDto(String name);
}
