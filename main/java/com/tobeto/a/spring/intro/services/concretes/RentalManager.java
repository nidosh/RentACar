package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.Rental;
import com.tobeto.a.spring.intro.repositories.RentalRepository;
import com.tobeto.a.spring.intro.services.abstracts.RentalService;
import com.tobeto.a.spring.intro.services.dtos.rental.request.AddRentalRequest;
import com.tobeto.a.spring.intro.services.dtos.rental.request.DeleteRentalRequest;
import com.tobeto.a.spring.intro.services.dtos.rental.request.UpdateRentalRequest;
import com.tobeto.a.spring.intro.services.dtos.rental.response.GetListRentalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;

@Service
public class RentalManager implements RentalService {
    @Autowired
    private RentalRepository rentalRepository;

    public RentalManager(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @Override
    public void add(AddRentalRequest request){
        Rental rental = new Rental();
        rental.setReturnDate(request.getReturnDate());
        rental.setEndDate(request.getEndDate());
        rental.setStartDate(request.getStartDate());
        rentalRepository.save(rental);
    }

    @Override
    public void delete(DeleteRentalRequest request) {
        Rental rentalToDelete = rentalRepository.findById(request.getId()).orElseThrow();
        rentalRepository.delete(rentalToDelete);
    }

    @Override
    public void update(UpdateRentalRequest request) {
        Rental rentalToUpdate = rentalRepository.findById(request.getId()).orElseThrow();
        rentalToUpdate.setReturnDate(request.getReturnDate());
        rentalToUpdate.setEndDate(request.getEndDate());
        rentalToUpdate.setStartDate(request.getStartDate());
        rentalRepository.save(rentalToUpdate);
    }

    @Override
    public List<GetListRentalResponse> getByReturnDateDto() {
        return null;
    }
    
    @Override
    public List<GetListRentalResponse> getByReturnDateDto(String rentalDate) {
        return null;
    }

    @Override
    public List<GetListRentalResponse> getByReturnDateDto(LocalDate rentalDate) {
        return rentalRepository.findByStartDateAfter(rentalDate)
                .stream()
                .map((Rental) -> new GetListRentalResponse(Rental.getReturnDate(),Rental.getEndDate(),Rental.getStartDate()))
                .toList();
    }

}
