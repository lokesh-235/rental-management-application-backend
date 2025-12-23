package com.example.rentalManagement.services.implementations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.rentalManagement.dtos.ActiveRentalDto;
import com.example.rentalManagement.dtos.ActiveRentalTenantDto;
import com.example.rentalManagement.dtos.PropertyDto;
import com.example.rentalManagement.dtos.UserDto;
import com.example.rentalManagement.entities.ActiveRental;
import com.example.rentalManagement.entities.User;
import com.example.rentalManagement.entities.ActiveRental.Status;
import com.example.rentalManagement.mappers.ActiveRentalMapper;
import com.example.rentalManagement.repositories.ActiveRentalRepository;
import com.example.rentalManagement.repositories.PropertyRepository;
import com.example.rentalManagement.services.ActiveRentalService;
import com.example.rentalManagement.services.PropertyService;
import com.example.rentalManagement.services.UserService;

@Service
public class ActiveRentalServiceImplementation implements ActiveRentalService{
	
	private ActiveRentalRepository activeRentalRepository;
	private PropertyService propertyService;
	private UserService userService;
	private PropertyRepository propertyRepository;
	
	public ActiveRentalServiceImplementation(ActiveRentalRepository activeRentalRepository , PropertyService propertyService , UserService userService,PropertyRepository propertyRepository) {
		this.activeRentalRepository = activeRentalRepository;
		this.propertyService = propertyService;
		this.userService = userService;
		this.propertyRepository = propertyRepository;
	}

	@Override
	public List<ActiveRentalTenantDto> getActiveRentals(Long ownerId) {
		// TODO Auto-generated method stub
		List<ActiveRental> activeRentals = this.activeRentalRepository.findByPropertyOwnerUserId(ownerId);
		System.out.println(activeRentals);
		
		
		
		List<ActiveRentalDto> activeRentalDtos = activeRentals.stream()
				.map((activeRental)->{
					PropertyDto property = this.propertyService.getPropertyByPropertyId(activeRental.getProperty().getPropertyId());
					UserDto tenant = this.userService.getUserByUserId(activeRental.getTenant().getUserId());
					return ActiveRentalMapper.toDto(activeRental, property, tenant);
				})
				.collect(Collectors.toList());
		
		Map<Long,Integer> map = new HashMap<>();
		List<ActiveRentalTenantDto>  activeRentalTenantDtos = new ArrayList<ActiveRentalTenantDto>();
		
		activeRentalDtos.stream().forEach((activeRentalDto) -> {
			if(map.containsKey(activeRentalDto.getTenantId()))
				activeRentalTenantDtos.get(map.get(activeRentalDto.getTenantId()))
				.getRentals().add(activeRentalDto);
			
			else {
				map.put(activeRentalDto.getTenantId(), activeRentalTenantDtos.size());
				UserDto tenant = userService.getUserByUserId(activeRentalDto.getTenantId());
				ActiveRentalTenantDto temp = new ActiveRentalTenantDto();
				temp.setEmail(tenant.getEmail());
				temp.setFullName(tenant.getFullName());
				temp.setTenantId(tenant.getUserId());
				temp.setPhone(tenant.getPhone());
				List<ActiveRentalDto> rentals = new ArrayList<>();
				rentals.add(activeRentalDto);
				temp.setRentals(rentals);

				temp.setRentals(rentals);
				
				activeRentalTenantDtos.add(temp);
			}
				
		});
		
		return activeRentalTenantDtos;
		
	}

	@Override
	public ActiveRentalDto addActiveRental(ActiveRentalDto activeRentalDto) {
		// TODO Auto-generated method stub
		
		User owner = this.propertyRepository.findOwnerByPropertyId(activeRentalDto.getProperty().getPropertyId());
		UserDto tenant = this.userService.getUserByUserId(activeRentalDto.getTenantId());
		ActiveRental activeRental = ActiveRentalMapper.toEntity(activeRentalDto,owner,tenant);
		activeRental.setStatus(Status.ACTIVE);
		ActiveRental savedActiveRental = this.activeRentalRepository.save(activeRental);
		
		PropertyDto property = this.propertyService.getPropertyByPropertyId(activeRental.getProperty().getPropertyId());
		
		
		return ActiveRentalMapper.toDto(savedActiveRental,property,tenant);
	}

	@Override
	public List<ActiveRentalDto> getActiveRentalsByTenantId(Long tenantId) {
		// TODO Auto-generated method stub
		List<ActiveRental> activeRentals = this.activeRentalRepository.findByTenantUserId(tenantId);
		System.out.println(activeRentals);
		List<ActiveRentalDto> activeRentalDtos = activeRentals.stream()
				.map((activeRental)->{
					PropertyDto property = this.propertyService.getPropertyByPropertyId(activeRental.getProperty().getPropertyId());
					UserDto tenant = this.userService.getUserByUserId(activeRental.getTenant().getUserId());
					return ActiveRentalMapper.toDto(activeRental, property, tenant);
				})
				
				.collect(Collectors.toList());
		
		return activeRentalDtos;
	}
	
	
	public ActiveRentalDto getActiveRentalByRentalId(Long rentalId) {
		ActiveRental activeRental = this.activeRentalRepository.findById(rentalId).orElseThrow(()->new RuntimeException("rental does not exist"));
		
		UserDto tenant = this.userService.getUserByUserId(activeRental.getTenant().getUserId());
		
		PropertyDto property = this.propertyService.getPropertyByPropertyId(activeRental.getProperty().getPropertyId());
		
		return ActiveRentalMapper.toDto(activeRental,property,tenant); 
		
	}
	
}
