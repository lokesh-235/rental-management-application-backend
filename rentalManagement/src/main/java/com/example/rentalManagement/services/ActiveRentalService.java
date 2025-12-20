package com.example.rentalManagement.services;

import java.util.List;

import org.jspecify.annotations.Nullable;

import com.example.rentalManagement.dtos.ActiveRentalDto;
import com.example.rentalManagement.dtos.ActiveRentalTenantDto;

public interface ActiveRentalService {
	ActiveRentalDto addActiveRental(ActiveRentalDto activeRentalDto);
	
	List<ActiveRentalTenantDto> getActiveRentals(Long ownerId);
	
	List<ActiveRentalDto> getActiveRentalsByTenantId(Long tenantId);
}
