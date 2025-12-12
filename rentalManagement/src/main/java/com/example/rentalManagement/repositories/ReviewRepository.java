package com.example.rentalManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rentalManagement.entities.Review;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByPropertyPropertyId(Long propertyId);

    List<Review> findByUserUserId(Long userId);
}

