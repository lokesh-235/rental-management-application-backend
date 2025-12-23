package com.example.rentalManagement.services;

import com.example.rentalManagement.dtos.PaymentRequestDto;
import com.example.rentalManagement.dtos.PaymentResponseDto;

public interface PaymentService {
	PaymentResponseDto makePayment(PaymentRequestDto paymentRequestDto);
}
