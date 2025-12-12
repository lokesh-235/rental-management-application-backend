package com.example.rentalManagement.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rentalManagement.entities.SavedProperty;

import java.util.List;

public interface SavedPropertyRepository extends JpaRepository<SavedProperty, Long> {

    List<SavedProperty> findByUserUserId(Long userId);

    boolean existsByUserUserIdAndPropertyPropertyId(Long userId, Long propertyId);

}

