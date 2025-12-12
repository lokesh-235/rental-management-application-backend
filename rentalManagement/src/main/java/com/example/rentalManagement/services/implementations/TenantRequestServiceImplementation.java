package com.example.rentalManagement.services.implementations;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.rentalManagement.dtos.TenantRequestDto;
import com.example.rentalManagement.entities.TenantRequest;
import com.example.rentalManagement.entities.TenantRequest.Status;
import com.example.rentalManagement.mappers.TenantRequestMapper;
import com.example.rentalManagement.repositories.TenantRequestRepository;
import com.example.rentalManagement.services.TenantRequestService;

@Service
public class TenantRequestServiceImplementation implements TenantRequestService{
	
	private TenantRequestRepository tenantRequestRepository;
	
	public TenantRequestServiceImplementation(TenantRequestRepository tenantRequestRepository) {
		this.tenantRequestRepository = tenantRequestRepository;
	}
	
	@Override
	public List<TenantRequestDto> getRequestsByOwnerId(Long id) {
		// TODO Auto-generated method stub
		List<TenantRequest> requests = this.tenantRequestRepository.findByPropertyOwnerUserId(id);
		List<TenantRequestDto> requestDtos = requests.stream()
				.map(TenantRequestMapper::toDto)
				.collect(Collectors.toList());
		System.out.println("request");
		return requestDtos;
	}

	@Override
	public void approveRequest(Long requestId) {
		// TODO Auto-generated method stub
		TenantRequest request = this.tenantRequestRepository.findById(requestId)
				.orElseThrow(()->
				new RuntimeException("Request Does not exist")
				);
		
		request.setStatus(Status.APPROVED);
		
		
		
		this.tenantRequestRepository.save(request);
		
	}

	@Override
	public void rejectRequest(Long requestId) {
		// TODO Auto-generated method stub
		TenantRequest request = this.tenantRequestRepository.findById(requestId)
				.orElseThrow(()->
				new RuntimeException("Request Does not exist")
				);
		
		request.setStatus(Status.REJECTED);
		
		this.tenantRequestRepository.save(request);
	}
	
	

}
