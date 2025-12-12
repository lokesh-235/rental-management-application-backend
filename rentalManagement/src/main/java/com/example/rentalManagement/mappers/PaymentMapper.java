package com.example.rentalManagement.mappers;

import com.example.rentalManagement.dtos.PaymentDto;
import com.example.rentalManagement.entities.Payment;

public class PaymentMapper {

    public static PaymentDto toDto(Payment pay) {
        if (pay == null) return null;

        PaymentDto dto = new PaymentDto();
        dto.setPaymentId(pay.getPaymentId());
        dto.setRentalId(pay.getRental().getRentalId());
        dto.setAmount(pay.getAmount());
        dto.setPaymentDate(pay.getPaymentDate());
        return dto;
    }

    public static Payment toEntity(PaymentDto dto) {
        if (dto == null) return null;

        Payment pay = new Payment();
        pay.setPaymentId(dto.getPaymentId());
        pay.setAmount(dto.getAmount());
        pay.setPaymentDate(dto.getPaymentDate());
        return pay;
    }
}
