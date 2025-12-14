package com.example.rentalManagement.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rentalManagement.entities.PropertyImage;

public interface PropertyImageRepository extends JpaRepository<PropertyImage, Long> {
	Optional<List<PropertyImage>> findByPropertyPropertyId(Long propertyId);
}

