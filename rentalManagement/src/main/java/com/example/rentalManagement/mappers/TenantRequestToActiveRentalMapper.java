package com.example.rentalManagement.mappers;

import com.example.rentalManagement.dtos.ActiveRentalDto;
import com.example.rentalManagement.dtos.PropertyDto;
import com.example.rentalManagement.dtos.UserDto;
import com.example.rentalManagement.entities.ActiveRental;
import com.example.rentalManagement.entities.ActiveRental.Status;
import com.example.rentalManagement.entities.TenantRequest;

public class TenantRequestToActiveRentalMapper {
//	public static ActiveRental toActiveRental(TenantRequest tenantRequest,Double rentAmount) {
//		if(tenantRequest==null) return null;
//		
//		ActiveRental activeRental = new ActiveRental();
//		activeRental.setProperty(tenantRequest.getProperty());
//		activeRental.setMonthlyRent(rentAmount);
//		activeRental.setTenant(tenantRequest.getTenant());
//		activeRental.setStatus(Status.ACTIVE);
//		
//		return activeRental;
//	}
	
	public static ActiveRentalDto toActiveRentalDto(TenantRequest tenantRequest,PropertyDto property,UserDto tenant) {
       if(tenantRequest==null) return null;
		
		ActiveRentalDto activeRentalDto = new ActiveRentalDto();
		activeRentalDto.setProperty(property);
		activeRentalDto.setMonthlyRent(property.getRentAmount());
		activeRentalDto.setTenantId(tenant.getUserId());
		activeRentalDto.setStatus(Status.ACTIVE);
		return activeRentalDto;
	}
}
