package com.example.rentalManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rentalManagement.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
    
    Optional<User> findByEmailAndPasswordHash(String email, String passwordHash);
}

