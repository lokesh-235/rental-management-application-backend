package com.example.rentalManagement.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rentalManagement.dtos.ActiveRentalDto;
import com.example.rentalManagement.services.ActiveRentalService;

@RestController
@RequestMapping("/api/properties/tenant/active-rentals")
public class ActiveRentalTenantController {
	
	private ActiveRentalService activeRentalService;
	
	public ActiveRentalTenantController(ActiveRentalService activeRentalService) {
		this.activeRentalService = activeRentalService;
	}
	
	@GetMapping("/{tenantId}")
	public ResponseEntity<List<ActiveRentalDto>> getActiveRentalsByTenantId(@PathVariable Long tenantId){
		return ResponseEntity.ok(this.activeRentalService.getActiveRentalsByTenantId(tenantId));
	}
}
