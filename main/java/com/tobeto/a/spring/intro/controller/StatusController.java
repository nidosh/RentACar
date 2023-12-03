package com.tobeto.a.spring.intro.controller;
import com.tobeto.a.spring.intro.entities.Statu;
import com.tobeto.a.spring.intro.services.abstracts.StatuService;
import com.tobeto.a.spring.intro.services.dtos.statu.request.AddStatuRequest;
import com.tobeto.a.spring.intro.services.dtos.statu.request.DeleteStatuRequest;
import com.tobeto.a.spring.intro.services.dtos.statu.request.UpdateStatuRequest;
import com.tobeto.a.spring.intro.services.dtos.statu.response.GetListStatuResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//Single Responsibility
@RestController
@RequestMapping("api/statu")
public class StatusController
{
    //Gelen isteği kontrol etmek ve yönlendirmek
    //Manager bağımlılığını yüklemek
    //BAĞIMLILIKLAR DAİMA SOYUT NESNELER ÜZERİNDEN
    private StatuService statuService;

    public StatusController(StatuService statuService) {
        this.statuService = statuService;
    }

    @PostMapping
    public void add(@RequestBody AddStatuRequest request){
        statuService.add(request);
    }

    @DeleteMapping
    public void delete(@PathVariable DeleteStatuRequest request){
        statuService.delete(request);
    }

    @PutMapping
    public void update(@RequestBody UpdateStatuRequest request){
        statuService.update(request);
    }

    //normal hali
    @GetMapping
    public List<Statu>getByName(@RequestParam String name){
        return statuService.getByName(name);
    }

    //dto'lu hali
    @GetMapping("dto")
    public List<GetListStatuResponse>getByNameDto(@RequestParam String name){
        return statuService.getByNameDto(name);
    }

}

