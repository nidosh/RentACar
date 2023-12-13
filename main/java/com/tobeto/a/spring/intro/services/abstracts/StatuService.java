package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.entities.Statu;
import com.tobeto.a.spring.intro.services.dtos.statu.request.AddStatuRequest;
import com.tobeto.a.spring.intro.services.dtos.statu.request.DeleteStatuRequest;
import com.tobeto.a.spring.intro.services.dtos.statu.request.UpdateStatuRequest;
import com.tobeto.a.spring.intro.services.dtos.statu.response.GetListStatuResponse;

import java.util.List;

public interface StatuService {
    void add(AddStatuRequest request);

    void delete(DeleteStatuRequest request);

    void update(UpdateStatuRequest request);

    List<GetListStatuResponse> getByName(String name);
    List<GetListStatuResponse> getByNameDto(String name);

    Statu getById(int id);
}

