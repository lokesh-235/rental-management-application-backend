package com.example.rentalManagement.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rentalManagement.entities.ActiveRental;

import java.util.List;

public interface ActiveRentalRepository extends JpaRepository<ActiveRental, Long> {

    List<ActiveRental> findByTenantUserId(Long tenantId);

    List<ActiveRental> findByPropertyPropertyId(Long propertyId);

    List<ActiveRental> findByStatus(ActiveRental.Status status);
    
    List<ActiveRental> findByPropertyOwnerUserId(Long id);
}

