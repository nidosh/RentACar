package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.Model;
import com.tobeto.a.spring.intro.repositories.ModelRepository;
import com.tobeto.a.spring.intro.services.abstracts.ModelService;
import com.tobeto.a.spring.intro.services.dtos.model.request.AddModelRequest;
import com.tobeto.a.spring.intro.services.dtos.model.request.DeleteModelRequest;
import com.tobeto.a.spring.intro.services.dtos.model.request.UpdateModelRequest;
import com.tobeto.a.spring.intro.services.dtos.model.response.GetListModelResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
public class ModelManager implements ModelService {
    @Autowired
    private ModelRepository modelRepository;

    @Override
    public void add(AddModelRequest request) {
        Model model =  new Model();
        model.setId(request.getId());
        model.setName(request.getName());
        modelRepository.save(model);
    }

    @Override
    public void delete(DeleteModelRequest request) {
        Model modelToDelete = modelRepository.findById(request.getId()).orElseThrow();
        modelRepository.delete(modelToDelete);
    }

    @Override
    public void update(UpdateModelRequest request) {
        Model modelToUpdate = modelRepository.findById(request.getId()).orElseThrow();
        modelToUpdate.setId(request.getId());
        modelToUpdate.setName(request.getName());
        modelRepository.save(modelToUpdate);
    }

    @Override
    public List<GetListModelResponse> getByNameDto(String name) {
        return modelRepository.findByName(name);
    }
}
