package com.tobeto.a.spring.intro.controller;
import com.tobeto.a.spring.intro.entities.Rental;
import com.tobeto.a.spring.intro.repositories.RentalRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rental")
public class RentalController
{
    public RentalController(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    private final RentalRepository rentalRepository;


    public List<Rental> getAll(){
        return rentalRepository.findAll();
    }

    @GetMapping("{id}")
    public Rental getAll(@PathVariable int id){
        return rentalRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Rental rental){
        rentalRepository.save(rental);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Rental rentalToDelete = rentalRepository.findById(id).orElseThrow();
        rentalRepository.delete(rentalToDelete);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Rental rental){
        Rental rentalToUpdate = rentalRepository.findById(id).orElseThrow();
        rentalToUpdate.setRentalDate(rental.getRentalDate());
        rentalToUpdate.setEndDate(rental.getEndDate());
        rentalRepository.save(rentalToUpdate);
    }


}
