package com.example.rentalManagement.services.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.rentalManagement.dtos.ActiveRentalDto;
import com.example.rentalManagement.entities.ActiveRental;
import com.example.rentalManagement.mappers.ActiveRentalMapper;
import com.example.rentalManagement.repositories.ActiveRentalRepository;
import com.example.rentalManagement.services.ActiveRentalService;

@Service
public class ActiveRentalImplementation implements ActiveRentalService{
	
	private ActiveRentalRepository activeRentalRepository;
	
	public ActiveRentalImplementation(ActiveRentalRepository activeRentalRepository) {
		this.activeRentalRepository = activeRentalRepository;
	}

	@Override
	public List<ActiveRentalDto> getActiveRentals(Long ownerId) {
		// TODO Auto-generated method stub
		List<ActiveRental> activeRentals = this.activeRentalRepository.findByPropertyOwnerUserId(ownerId);
		System.out.println(activeRentals);
		List<ActiveRentalDto> activeRentalDtos = activeRentals.stream()
				.map(ActiveRentalMapper::toDto)
				.collect(Collectors.toList());
		
		return activeRentalDtos;
	}

	@Override
	public ActiveRentalDto addActiveRental(ActiveRentalDto activeRentalDto) {
		// TODO Auto-generated method stub
		ActiveRental activeRental = ActiveRentalMapper.toEntity(activeRentalDto);
		ActiveRental savedActiveRental = this.activeRentalRepository.save(activeRental);
		
		return ActiveRentalMapper.toDto(savedActiveRental);
	}
}
