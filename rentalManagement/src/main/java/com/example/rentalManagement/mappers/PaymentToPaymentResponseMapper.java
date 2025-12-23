package com.example.rentalManagement.mappers;

import com.example.rentalManagement.dtos.ActiveRentalDto;
import com.example.rentalManagement.dtos.PaymentResponseDto;
import com.example.rentalManagement.entities.Payment;

public class PaymentToPaymentResponseMapper {
	public static PaymentResponseDto toPaymentResponse(Payment payment,String ownerName,String propertyTitle) {
		if(payment==null) return null;
		PaymentResponseDto paymentResponseDto = new PaymentResponseDto();
		
		paymentResponseDto.setAmount(payment.getAmount());
		paymentResponseDto.setPaymentDate(payment.getPaymentDate());
		paymentResponseDto.setPaymentId(payment.getPaymentId());
		paymentResponseDto.setPaymentMethod(payment.getPaymentMethod());
		paymentResponseDto.setPaymentStatus(payment.getPaymentStatus());
		paymentResponseDto.setOwnerName(ownerName);
		paymentResponseDto.setPropertyTitle(propertyTitle);
		return paymentResponseDto;
	}
}
