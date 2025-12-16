package com.example.rentalManagement.services;

import java.util.List;

import com.example.rentalManagement.dtos.TenantRequestDto;
import com.example.rentalManagement.dtos.TenantRequestRequestDto;

public interface TenantRequestService {
	TenantRequestDto addRequest(TenantRequestRequestDto tenantRequestRequestDto);
	
	List<TenantRequestDto> getRequestsByOwnerId(Long ownerId);

	void approveRequest(Long requestId);
	
	void rejectRequest(Long requestId);
}
