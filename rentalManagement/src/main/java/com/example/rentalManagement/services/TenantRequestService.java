package com.example.rentalManagement.services;

import java.util.List;

import com.example.rentalManagement.dtos.TenantRequestDto;

public interface TenantRequestService {
	List<TenantRequestDto> getRequestsByOwnerId(Long id);

	void approveRequest(Long requestId);
	
	void rejectRequest(Long requestId);
}
