package com.example.rentalManagement.services.implementations;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.rentalManagement.dtos.ActiveRentalDto;
import com.example.rentalManagement.dtos.TenantRequestDto;
import com.example.rentalManagement.dtos.TenantRequestRequestDto;
import com.example.rentalManagement.entities.Property;
import com.example.rentalManagement.entities.TenantRequest;
import com.example.rentalManagement.entities.TenantRequest.Status;
import com.example.rentalManagement.entities.User;
import com.example.rentalManagement.mappers.TenantRequestMapper;
import com.example.rentalManagement.mappers.TenantRequestRequestDtoToTenantRequest;
import com.example.rentalManagement.mappers.TenantRequestToActiveRentalMapper;
import com.example.rentalManagement.repositories.PropertyRepository;
import com.example.rentalManagement.repositories.TenantRequestRepository;
import com.example.rentalManagement.repositories.UserRepository;
import com.example.rentalManagement.services.TenantApprovalService;
import com.example.rentalManagement.services.TenantRequestService;

@Service
public class TenantRequestServiceImplementation implements TenantRequestService{
	
	private TenantRequestRepository tenantRequestRepository;
	private PropertyRepository propertyRepository;
	private UserRepository userRepository;
	private TenantApprovalService tenantApprovalService;
	
	private ActiveRentalImplementation activeRentalImplementation;
	public TenantRequestServiceImplementation(TenantRequestRepository tenantRequestRepository,PropertyRepository propertyRepository,ActiveRentalImplementation activeRentalImplementation,UserRepository userRepository,TenantApprovalService tenantApprovalService) {
		this.tenantRequestRepository = tenantRequestRepository;
		this.propertyRepository = propertyRepository;
		this.activeRentalImplementation = activeRentalImplementation;
		this.userRepository = userRepository;
		this.tenantApprovalService = tenantApprovalService;
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
		
		//add to active rentals
		Property property = this.propertyRepository
				         .findById(request.getProperty()
						.getPropertyId())
				        .orElseThrow(()->
				        new RuntimeException("Property does not exist"));
		
		ActiveRentalDto activeRentalDto = TenantRequestToActiveRentalMapper.toActiveRentalDto(request, property.getRentAmount());
		activeRentalImplementation.addActiveRental(activeRentalDto);
		
		this.tenantRequestRepository.save(request);
		
		this.tenantApprovalService.approveTenantRequest(requestId);
		
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

	@Override
	public TenantRequestDto addRequest(TenantRequestRequestDto tenantRequestRequestDto) {
		// TODO Auto-generated method stub
		Long propertyId = tenantRequestRequestDto.getPropertyId();
		Long tenantId = tenantRequestRequestDto.getTenantId();
		String message = tenantRequestRequestDto.getMessage();
		
		Property property = this.propertyRepository.findById(propertyId)
				.orElseThrow(()->
				new RuntimeException("property does not exist"));
		
		User tenant = this.userRepository.findById(tenantId)
				.orElseThrow(()->
				new RuntimeException("tenant does not exist"));
		
		TenantRequest tenantRequest = TenantRequestRequestDtoToTenantRequest.toTenantRequest(message, property, tenant);
		
		TenantRequest savedTenantRequest = this.tenantRequestRepository.save(tenantRequest);
		
		return TenantRequestMapper.toDto(savedTenantRequest);
	}
	
	

}
