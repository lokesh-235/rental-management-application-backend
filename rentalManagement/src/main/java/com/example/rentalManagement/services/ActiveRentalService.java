package com.example.rentalManagement.services;

import java.util.List;

import com.example.rentalManagement.dtos.ActiveRentalDto;

public interface ActiveRentalService {
	List<ActiveRentalDto> getActiveRentals(Long ownerId);
}
