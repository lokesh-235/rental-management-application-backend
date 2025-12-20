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
@RequestMapping("/api/tenant/active-rentals")
public class TenantActiveRentalController {
	
	private ActiveRentalService activeRentalService;
	
	public TenantActiveRentalController(ActiveRentalService activeRentalService) {
		this.activeRentalService = activeRentalService;
	}
	
	@GetMapping("/{tenantId}")
	public ResponseEntity<List<ActiveRentalDto>> getActiveRentalsByTenantId(@PathVariable Long tenantId){
		return ResponseEntity.ok(this.activeRentalService.getActiveRentalsByTenantId(tenantId));
	}
	
}
