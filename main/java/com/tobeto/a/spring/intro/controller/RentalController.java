package com.tobeto.a.spring.intro.controller;

import com.tobeto.a.spring.intro.entities.Rental;
import com.tobeto.a.spring.intro.services.abstracts.RentalService;
import com.tobeto.a.spring.intro.services.dtos.rental.request.AddRentalRequest;
import com.tobeto.a.spring.intro.services.dtos.rental.request.DeleteRentalRequest;
import com.tobeto.a.spring.intro.services.dtos.rental.request.UpdateRentalRequest;
import com.tobeto.a.spring.intro.services.dtos.rental.response.GetListRentalResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rental")
public class RentalController
{
    private RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @PostMapping
    public void add(@RequestBody AddRentalRequest request){
        rentalService.add(request);
    }

    @DeleteMapping
    public void delete(@PathVariable DeleteRentalRequest request){
        rentalService.delete(request);
    }

    @PutMapping
    public void update(@RequestBody UpdateRentalRequest request){
        rentalService.update(request);
    }

    @GetMapping("dto")
    public List<GetListRentalResponse>getByRentalDateDto(@RequestParam String rentalDate){
        return rentalService.getByRentalDateDto(rentalDate);
    }
}
