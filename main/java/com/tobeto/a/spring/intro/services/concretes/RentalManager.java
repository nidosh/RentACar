package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.Rental;
import com.tobeto.a.spring.intro.repositories.RentalRepository;
import com.tobeto.a.spring.intro.services.abstracts.RentalService;
import com.tobeto.a.spring.intro.services.dtos.rental.request.AddRentalRequest;
import com.tobeto.a.spring.intro.services.dtos.rental.request.DeleteRentalRequest;
import com.tobeto.a.spring.intro.services.dtos.rental.request.UpdateRentalRequest;
import com.tobeto.a.spring.intro.services.dtos.rental.response.GetListRentalResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalManager implements RentalService {
    private RentalRepository rentalRepository;

    public RentalManager(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @Override
    public void add(AddRentalRequest request){
        Rental rental = new Rental();
        rental.setRentalDate(request.getRentalDate());
        rental.setEndDate(request.getEndDate());
        rentalRepository.save(rental);
    }

    @Override
    public void delete(DeleteRentalRequest request) {
        Rental rentalToDelete = rentalRepository.findById(request.getRentalId()).orElseThrow();
        rentalRepository.delete(rentalToDelete);
    }

    @Override
    public void update(UpdateRentalRequest request) {
        Rental rentalToUpdate = rentalRepository.findById(request.getRentalId()).orElseThrow();
        rentalToUpdate.setRentalDate(request.getRentalDate());
        rentalToUpdate.setEndDate(request.getEndDate());
        rentalRepository.save(rentalToUpdate);
    }

    @Override
    public List<GetListRentalResponse> getByRentalDateDto(String rentalDate) {
        return rentalRepository.findByStartDateAfter(rentalDate)
                .stream()
                .map((Rental) -> new GetListRentalResponse(Rental.getRentalDate(),Rental.getEndDate()))
                .toList();
    }

}
