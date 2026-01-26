package com.example.rentalManagement.services.implementations;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.example.rentalManagement.dtos.ActiveRentalDto;
import com.example.rentalManagement.dtos.OwnerPaymentsDto;
import com.example.rentalManagement.dtos.PaymentRequestDto;
import com.example.rentalManagement.dtos.PaymentResponseDto;
import com.example.rentalManagement.entities.ActiveRental;
import com.example.rentalManagement.entities.Payment;
import com.example.rentalManagement.mappers.PaymentRequestToPaymentMapper;
import com.example.rentalManagement.mappers.PaymentToOwnerPaymentsDtoMapper;
import com.example.rentalManagement.mappers.PaymentToPaymentResponseMapper;
import com.example.rentalManagement.repositories.ActiveRentalRepository;
import com.example.rentalManagement.repositories.PaymentRepository;
import com.example.rentalManagement.services.ActiveRentalService;
import com.example.rentalManagement.services.PaymentService;


@Service
public class PaymentServiceImplementation implements PaymentService {
	
	private PaymentRepository paymentRepository;
	private ActiveRentalRepository activeRentalRepository;
	private ActiveRentalService activeRentalService;
	
	public PaymentServiceImplementation(ActiveRentalRepository activeRentalRepository , PaymentRepository paymentRepository , ActiveRentalService activeRentalService) {
		this.activeRentalRepository = activeRentalRepository;
		this.paymentRepository = paymentRepository;
		this.activeRentalService = activeRentalService;
	}

	@Override
	public PaymentResponseDto makePayment(PaymentRequestDto paymentRequestDto) {
		String paymentStatus = "PENDING";
		// TODO Auto-generated method stub
	
		
		//payment process
//		.........
		
		//store the details in payments table
		ActiveRental activeRental = this.activeRentalRepository.findById(paymentRequestDto.getRentalId())
				.orElseThrow(() -> new RuntimeException("rental does not exist"));
		
		Payment payment = PaymentRequestToPaymentMapper.toEntity(paymentRequestDto, activeRental);
		
		payment.setPaymentStatus("SUCCESS");
		
		Payment savedPayment = this.paymentRepository.save(payment);
		
//		ActiveRentalDto activeRentalDto = this.activeRentalService.getActiveRentalByRentalId(activeRental.getRentalId());
		
		String ownerName = activeRental.getProperty().getOwner().getFullName();
		String propertyTitle = activeRental.getProperty().getTitle();
		
		return PaymentToPaymentResponseMapper.toPaymentResponse(savedPayment ,ownerName , propertyTitle );
		
	}

	@Override
	public List<OwnerPaymentsDto> getPaymentsByOwnerId(Long ownerId) {
		// TODO Auto-generated method stub
		List<Payment> payments = this.paymentRepository.findByRentalPropertyOwnerUserId(ownerId);
		
		Stream<Payment> stream = payments.stream();
		
		List<OwnerPaymentsDto> ownerPaymentsDtos = stream.map(PaymentToOwnerPaymentsDtoMapper::toOwnerPaymentsDto).toList();
		
		return ownerPaymentsDtos;
	}
	
}
