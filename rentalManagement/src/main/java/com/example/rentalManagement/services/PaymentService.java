package com.example.rentalManagement.services;

import java.util.List;

import com.example.rentalManagement.dtos.OwnerPaymentsDto;
import com.example.rentalManagement.dtos.PaymentRequestDto;
import com.example.rentalManagement.dtos.PaymentResponseDto;

public interface PaymentService {
	PaymentResponseDto makePayment(PaymentRequestDto paymentRequestDto);
	
	List<OwnerPaymentsDto> getPaymentsByOwnerId(Long ownerId);
	
}
