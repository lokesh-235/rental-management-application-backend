package com.example.rentalManagement.services;

import java.util.List;

import com.example.rentalManagement.dtos.ActiveRentalDto;

public interface ActiveRentalService {
	ActiveRentalDto addActiveRental(ActiveRentalDto activeRentalDto);
	List<ActiveRentalDto> getActiveRentals(Long ownerId);
}
