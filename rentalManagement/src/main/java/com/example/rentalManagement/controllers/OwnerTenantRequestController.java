package com.example.rentalManagement.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rentalManagement.dtos.TenantRequestDto;
import com.example.rentalManagement.services.TenantRequestService;

@RestController
@RequestMapping("/api/properties/owner")
public class OwnerTenantRequestController {
	
	TenantRequestService tenantRequestService;
	
	public OwnerTenantRequestController(TenantRequestService tenantRequestService) {
		this.tenantRequestService = tenantRequestService;
	}
	
	@GetMapping("/{id}/requests")
	public ResponseEntity<List<TenantRequestDto>> getRequestsByOwnerId(@PathVariable Long id) {
		return ResponseEntity.ok(this.tenantRequestService.getRequestsByOwnerId(id));
	}
	
	@PutMapping("/{requestId}/approve")
	public ResponseEntity<String> approveRequest(@PathVariable Long requestId){
		this.tenantRequestService.approveRequest(requestId);
		System.out.println("request approved");
		return ResponseEntity.ok("Request Approved");
	}
	
	@PutMapping("/{requestId}/reject")
	public ResponseEntity<String> rejectRequest(@PathVariable Long requestId){
		this.tenantRequestService.rejectRequest(requestId);
		System.out.println("request rejected");
		return ResponseEntity.ok("Request rejected");
	}
}
