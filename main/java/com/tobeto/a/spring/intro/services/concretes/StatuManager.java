package com.tobeto.a.spring.intro.services.concretes;


import com.tobeto.a.spring.intro.entities.Statu;
import com.tobeto.a.spring.intro.repositories.StatuRepository;
import com.tobeto.a.spring.intro.services.abstracts.StatuService;
import com.tobeto.a.spring.intro.services.dtos.statu.request.AddStatuRequest;
import com.tobeto.a.spring.intro.services.dtos.statu.request.DeleteStatuRequest;
import com.tobeto.a.spring.intro.services.dtos.statu.request.UpdateStatuRequest;
import org.springframework.stereotype.Service;


//Manager
@Service
public class StatuManager implements StatuService
{

    private StatuRepository statuRepository;

    public StatuManager(StatuRepository statuRepository) {
        this.statuRepository = statuRepository;
    }

    @Override
    public void add(AddStatuRequest request) {
        Statu statu = new Statu();
        statu.setCarStatus(request.getCarStatus());
        statuRepository.save(statu);
    }

    @Override
    public void delete(DeleteStatuRequest request) {
        Statu statuToDelete = statuRepository.findById(request.getStatuId()).orElseThrow();
        statuRepository.delete(statuToDelete);
    }

    @Override
    public void update(UpdateStatuRequest request) {
        Statu statuToUpdate = statuRepository.findById(request.getStatuId()).orElseThrow();
        statuToUpdate.setCarStatus(request.getCarStatus());
        statuRepository.save(statuToUpdate);
    }

}
