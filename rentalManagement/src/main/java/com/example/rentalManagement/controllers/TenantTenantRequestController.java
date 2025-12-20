package com.example.rentalManagement.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rentalManagement.dtos.TenantRequestDto;
import com.example.rentalManagement.dtos.TenantRequestRequestDto;
import com.example.rentalManagement.services.TenantRequestService;

@RestController 
@RequestMapping("/api/tenant/requests")
public class TenantTenantRequestController {
	
	private TenantRequestService tenantRequestService;
	
	public TenantTenantRequestController(TenantRequestService tenantRequestService) {
		this.tenantRequestService = tenantRequestService;
	}
	
	@PostMapping
	public ResponseEntity<TenantRequestDto> postRequest(@RequestBody TenantRequestRequestDto tenantRequestRequestDto){
		return ResponseEntity.ok(this.tenantRequestService.addRequest(tenantRequestRequestDto));
	}
	
	@GetMapping("/{tenantId}")
	public ResponseEntity<List<TenantRequestDto>> getTenantRequestsByTenantId(@PathVariable Long tenantId) {
		return ResponseEntity.ok(this.tenantRequestService.getTenantRequestsByTenantId(tenantId));
	}
	
	
}
