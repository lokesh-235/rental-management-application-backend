package com.example.rentalManagement.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rentalManagement.dtos.ActiveRentalDto;
import com.example.rentalManagement.dtos.ActiveRentalTenantDto;
import com.example.rentalManagement.services.ActiveRentalService;

@RestController
@RequestMapping("/api/owner/active-rentals")
public class ActiveRentalController {
	
	private ActiveRentalService activeRentalService;
	
	public ActiveRentalController(ActiveRentalService activeRentalService) {
		this.activeRentalService = activeRentalService;
	}
	
	@GetMapping("/{ownerId}")
	public ResponseEntity<List<ActiveRentalTenantDto>> getActiveRentals(@PathVariable Long ownerId){
		return ResponseEntity.ok(this.activeRentalService.getActiveRentals(ownerId));
	}
	
	
}
