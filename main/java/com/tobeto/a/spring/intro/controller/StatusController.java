package com.tobeto.a.spring.intro.controller;

import com.tobeto.a.spring.intro.entities.Statu;
import com.tobeto.a.spring.intro.repositories.StatuRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/statu")
public class StatusController
{
    //final => sadece ctor'da ilgili değerin ataması yapılabileceğini söyler.
    private final StatuRepository statuRepository;

    public StatusController(StatuRepository statuRepository)
    {
        this.statuRepository = statuRepository;
    }
    //Dependency Injection
    //Spring IoC => DI Container

    @GetMapping
    public List<Statu> getAll() {
        //findAll=> hazır bir jpa repo fonksiyonudur.
        //tüm verileri döner

        return statuRepository.findAll();
    }

    @GetMapping("{id}")
    public Statu getById(@PathVariable int id){
        //Optional => opsiyonel olarak Statu
        //verilen id ile bir veri varsa onu yoksa exception fırlat demiş olduk.
        return statuRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Statu statu)
    {
        statuRepository.save(statu);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Statu statuToDelete = statuRepository.findById(id).orElseThrow();
        //exception fırlaması 0 bu satırın çalışmaması
        statuRepository.delete(statuToDelete);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Statu statu){
        Statu statuToUpdate = statuRepository.findById(id).orElseThrow();
        statuToUpdate.setCarStatus(statu.getCarStatus());
        statuRepository.save(statuToUpdate);
    }

    //UPDATE
    //en az 5 entitiy için CRUD operayonları oluşturulması.
}
//http://localhost:8080/api/statu GET

//JSON Infinite Recursion