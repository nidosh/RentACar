package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.concretes.Statu;
import com.tobeto.a.spring.intro.repositories.StatuRepository;
import com.tobeto.a.spring.intro.services.abstracts.StatuService;
import com.tobeto.a.spring.intro.services.dtos.statu.request.AddStatuRequest;
import com.tobeto.a.spring.intro.services.dtos.statu.request.DeleteStatuRequest;
import com.tobeto.a.spring.intro.services.dtos.statu.request.UpdateStatuRequest;
import com.tobeto.a.spring.intro.services.dtos.statu.response.GetListStatuResponse;
import lombok.Data;
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
}


