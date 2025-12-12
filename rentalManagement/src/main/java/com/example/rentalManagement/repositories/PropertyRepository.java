package com.example.rentalManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rentalManagement.entities.Property;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long> {

    List<Property> findByCity(String city);

    List<Property> findByOwnerUserId(Long ownerId);

    List<Property> findByAddressContaining(String keyword);
    
    
}

