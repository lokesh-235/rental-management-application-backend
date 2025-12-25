package com.example.rentalManagement.services.implementations;

import java.util.List;



import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.rentalManagement.dtos.ActiveRentalDto;
import com.example.rentalManagement.dtos.PropertyDto;
import com.example.rentalManagement.dtos.TenantRequestDto;
import com.example.rentalManagement.dtos.TenantRequestRequestDto;
import com.example.rentalManagement.dtos.UserDto;
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
import com.example.rentalManagement.services.ActiveRentalService;
import com.example.rentalManagement.services.PropertyService;
import com.example.rentalManagement.services.TenantRequestService;
import com.example.rentalManagement.services.UpdatePropertiesAfterTenantRequestApprovalService;
import com.example.rentalManagement.services.UserService;
import com.example.rentalManagement.services.publishers.PropertyEventPublisher;

@Service
public class TenantRequestServiceImplementation implements TenantRequestService{
	
	private TenantRequestRepository tenantRequestRepository;
	private PropertyRepository propertyRepository;
	private UserRepository userRepository;
	private UpdatePropertiesAfterTenantRequestApprovalService updatePropertiesAftertenantRequestApprovalService;
	private ActiveRentalService activeRentalService;
	private UserService userService;
	private PropertyService propertyService;
	private PropertyEventPublisher propertyEventPublisher;
	
	public TenantRequestServiceImplementation(TenantRequestRepository tenantRequestRepository
			,PropertyRepository propertyRepository
			,ActiveRentalService activeRentalService
			,UserRepository userRepository
			,UpdatePropertiesAfterTenantRequestApprovalService updatePropertiesAftertenantRequestApprovalService
			,UserService userService,PropertyService propertyService
			,PropertyEventPublisher propertyEventPublisher) 
	
	{
		this.tenantRequestRepository = tenantRequestRepository;
		this.propertyRepository = propertyRepository;
		this.activeRentalService = activeRentalService;
		this.userRepository = userRepository;
		this.updatePropertiesAftertenantRequestApprovalService = updatePropertiesAftertenantRequestApprovalService;
		this.userService = userService;
		this.propertyService = propertyService;
		this.propertyEventPublisher = propertyEventPublisher;
	}
	
	@Override
	public List<TenantRequestDto> getRequestsByOwnerId(Long id) {
		// TODO Auto-generated method stub
		List<TenantRequest> requests = this.tenantRequestRepository.findByPropertyOwnerUserIdOrderByRequestedAtDesc(id);
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
		
		//add to active rentals
//		Property property = this.propertyRepository
//				         .findById(request.getProperty()
//						.getPropertyId())
//				        .orElseThrow(()->
//				        new RuntimeException("Property does not exist"));
		
		PropertyDto property = this.propertyService.getPropertyByPropertyId(request.getProperty().getPropertyId());
		
		UserDto tenant = this.userService.getUserByUserId(request.getTenant().getUserId());
		
		ActiveRentalDto activeRentalDto = TenantRequestToActiveRentalMapper.toActiveRentalDto(request, property,tenant);
		activeRentalService.addActiveRental(activeRentalDto);
		
		
		
		this.updatePropertiesAftertenantRequestApprovalService.approveTenantRequest(requestId);
		
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

	@Override
	public List<TenantRequestDto> getTenantRequestsByTenantId(Long tenantId) {
		// TODO Auto-generated method stub
		List<TenantRequest> tenantRequests = this.tenantRequestRepository.findByTenantUserId(tenantId);
		
		List<TenantRequestDto> requestDtos = tenantRequests.stream()
				.map(TenantRequestMapper::toDto)
				.collect(Collectors.toList());
		
		System.out.println("tenant requests");
		
		return requestDtos;
	}
	
	

}
