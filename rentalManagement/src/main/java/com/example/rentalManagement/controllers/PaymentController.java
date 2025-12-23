package com.example.rentalManagement.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rentalManagement.dtos.PaymentRequestDto;
import com.example.rentalManagement.dtos.PaymentResponseDto;
import com.example.rentalManagement.services.PaymentService;

@RestController
@RequestMapping("/api/payments/")
public class PaymentController {
	
	private PaymentService paymentService;
	
	
	
	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}



	@PostMapping("/make-payment")
	public ResponseEntity<PaymentResponseDto> makePayment(@RequestBody PaymentRequestDto paymentRequestDto){
		return ResponseEntity.ok(paymentService.makePayment(paymentRequestDto));
	}
}
