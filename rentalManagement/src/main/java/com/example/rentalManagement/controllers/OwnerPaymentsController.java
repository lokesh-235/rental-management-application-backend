package com.example.rentalManagement.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rentalManagement.dtos.OwnerPaymentsDto;
import com.example.rentalManagement.services.PaymentService;

@RestController
@RequestMapping("/api/owner")
public class OwnerPaymentsController {
	private PaymentService paymentService;

	public OwnerPaymentsController(PaymentService paymentService) {
		
		this.paymentService = paymentService;
	}
	
	@GetMapping("/get-payments/{ownerId}")
	public ResponseEntity<List<OwnerPaymentsDto>> getPaymentsByOwnerId(@PathVariable Long ownerId){
		return ResponseEntity.ok(paymentService.getPaymentsByOwnerId(ownerId));
	}
}
