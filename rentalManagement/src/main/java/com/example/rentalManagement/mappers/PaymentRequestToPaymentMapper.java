package com.example.rentalManagement.mappers;


import com.example.rentalManagement.dtos.PaymentRequestDto;
import com.example.rentalManagement.entities.ActiveRental;
import com.example.rentalManagement.entities.Payment;

public class PaymentRequestToPaymentMapper {



    public static Payment toEntity(PaymentRequestDto dto , ActiveRental activeRental) {
        if (dto == null) return null;

        Payment payment = new Payment();
//        pay.setPaymentId(dto.getPaymentId());
        payment.setRental(activeRental);
        payment.setAmount(dto.getAmount());
        payment.setPaymentMethod(dto.getPaymentMethod());
        return payment;
    }
}
