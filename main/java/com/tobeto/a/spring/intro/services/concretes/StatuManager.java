package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.Statu;
import com.tobeto.a.spring.intro.repositories.StatuRepository;
import com.tobeto.a.spring.intro.services.abstracts.StatuService;
import com.tobeto.a.spring.intro.services.dtos.statu.request.AddStatuRequest;
import com.tobeto.a.spring.intro.services.dtos.statu.request.DeleteStatuRequest;
import com.tobeto.a.spring.intro.services.dtos.statu.request.UpdateStatuRequest;
import com.tobeto.a.spring.intro.services.dtos.statu.response.GetListStatuResponse;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//Manager
@Service
@Data
public class StatuManager implements StatuService
{
    private StatuRepository statuRepository;

    public StatuManager(StatuRepository statuRepository) {
        this.statuRepository = statuRepository;
    }

    @Override
    public void add(AddStatuRequest request) {
        Statu statu = new Statu();
        statu.setName(request.getName());
        statuRepository.save(statu);
    }

    @Override
    public void delete(DeleteStatuRequest request) {
        Statu statuToDelete = statuRepository.findById(request.getId()).orElseThrow();
        statuRepository.delete(statuToDelete);
    }

    @Override
    public void update(UpdateStatuRequest request) {
        Statu statuToUpdate = statuRepository.findById(request.getId()).orElseThrow();
        statuToUpdate.setName(request.getName());
        statuRepository.save(statuToUpdate);
    }

    @Override
    public List<GetListStatuResponse> getByName(String name) {
        //return statuRepository.findByNameStartingWith(name);
        return statuRepository.findByNameStartingWith(name)
                .stream()
                .map((statu -> new GetListStatuResponse(statu.getName(), statu.getId())))
                .toList();
    }

    @Override
    public List<GetListStatuResponse> getByNameDto(String name) {

        return statuRepository.findByName(name);
    }
    @Override
    public Statu getById(int statuId) {
        return null;
    }

    @Override
    public List<GetListStatuResponse> getAll() {
        return statuRepository.findAll().stream()
                .map(statu -> new GetListStatuResponse(statu.getName(), statu.getId()))
                .toList();
    }

}


