package com.example.rentalManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rentalManagement.entities.Payment;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findByRentalRentalId(Long rentalId);
}
