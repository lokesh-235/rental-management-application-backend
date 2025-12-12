package com.example.rentalManagement.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rentalManagement.entities.PropertyImage;

public interface PropertyImageRepository extends JpaRepository<PropertyImage, Long> {
}

