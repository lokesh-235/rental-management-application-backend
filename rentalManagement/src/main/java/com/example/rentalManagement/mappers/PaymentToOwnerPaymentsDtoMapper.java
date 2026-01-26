package com.example.rentalManagement.mappers;

import com.example.rentalManagement.dtos.OwnerPaymentsDto;
import com.example.rentalManagement.entities.Payment;

public class PaymentToOwnerPaymentsDtoMapper {
	public static OwnerPaymentsDto toOwnerPaymentsDto(Payment payment) {
		OwnerPaymentsDto ownerPaymentsDto = new OwnerPaymentsDto();
		
		ownerPaymentsDto.setAmount(payment.getAmount());
		ownerPaymentsDto.setPaymentDate(payment.getPaymentDate());
		ownerPaymentsDto.setPaymentId(payment.getPaymentId());
		ownerPaymentsDto.setPaymentMethod(payment.getPaymentMethod());
		ownerPaymentsDto.setPaymentStatus(payment.getPaymentStatus());
		ownerPaymentsDto.setPropertyTitle(payment.getRental().getProperty().getTitle());
		ownerPaymentsDto.setTenantName(payment.getRental().getTenant().getFullName());
		
		
		return ownerPaymentsDto;
	}
}
