package com.example.rentalManagement.mappers;

import com.example.rentalManagement.dtos.ActiveRentalDto;
import com.example.rentalManagement.entities.ActiveRental;
import com.example.rentalManagement.entities.ActiveRental.Status;
import com.example.rentalManagement.entities.TenantRequest;

public class TenantRequestToActiveRentalMapper {
	public static ActiveRental toActiveRental(TenantRequest tenantRequest,Double rentAmount) {
		if(tenantRequest==null) return null;
		
		ActiveRental activeRental = new ActiveRental();
		activeRental.setProperty(tenantRequest.getProperty());
		activeRental.setMonthlyRent(rentAmount);
		activeRental.setTenant(tenantRequest.getTenant());
		activeRental.setStatus(Status.ACTIVE);
		
		return activeRental;
	}
	
	public static ActiveRentalDto toActiveRentalDto(TenantRequest tenantRequest,Double rentAmount) {
       if(tenantRequest==null) return null;
		
		ActiveRentalDto activeRentalDto = new ActiveRentalDto();
		activeRentalDto.setPropertyId(tenantRequest.getProperty().getPropertyId());
		activeRentalDto.setMonthlyRent(rentAmount);
		activeRentalDto.setTenantId(tenantRequest.getTenant().getUserId());
		activeRentalDto.setStatus(Status.ACTIVE);
		return activeRentalDto;
	}
}
