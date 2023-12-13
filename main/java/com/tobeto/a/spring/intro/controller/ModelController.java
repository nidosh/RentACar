package com.tobeto.a.spring.intro.controller;

import com.tobeto.a.spring.intro.services.abstracts.ModelService;
import com.tobeto.a.spring.intro.services.dtos.model.request.AddModelRequest;
import com.tobeto.a.spring.intro.services.dtos.model.request.DeleteModelRequest;
import com.tobeto.a.spring.intro.services.dtos.model.request.UpdateModelRequest;
import com.tobeto.a.spring.intro.services.dtos.model.response.GetListModelResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/model")
@RestController
@AllArgsConstructor
public class ModelController {
    private ModelService modelService;

    @PostMapping
    public void add(@RequestBody @Valid AddModelRequest request){
        modelService.add(request);
    }

    @DeleteMapping
    public void delete(@PathVariable @Valid DeleteModelRequest request){
        modelService.delete(request);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateModelRequest request){
        modelService.update(request);
    }

    @GetMapping("dto")
    public List<GetListModelResponse>getByNameDto(@RequestParam String name){
        return modelService.getByNameDto(name);
    }
}
