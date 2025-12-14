package com.example.rentalManagement.services;

import java.util.List;

import org.jspecify.annotations.Nullable;

import com.example.rentalManagement.dtos.ActiveRentalDto;

public interface ActiveRentalService {
	ActiveRentalDto addActiveRental(ActiveRentalDto activeRentalDto);
	List<ActiveRentalDto> getActiveRentals(Long ownerId);
	
	List<ActiveRentalDto> getActiveRentalsByTenantId(Long tenantId);
}
