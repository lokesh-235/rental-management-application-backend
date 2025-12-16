package com.example.rentalManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.rentalManagement.entities.Property;
import com.example.rentalManagement.entities.User;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long> {
	
	@Query("""
			SELECT p FROM Property p
			WHERE NOT EXISTS (
			    SELECT 1 FROM ActiveRental ar
			    WHERE ar.property.propertyId = p.propertyId AND ar.status = 'ACTIVE'
			)
			""")
	List<Property> findAvailableProperties();


    List<Property> findByCity(String city);

    List<Property> findByOwnerUserId(Long ownerId);

    List<Property> findByAddressContaining(String keyword);
    
    Double findRentAmountByPropertyId(Long propertyId);
    
    @Query("SELECT p.owner FROM Property p WHERE p.propertyId = :propertyId")
    User findOwnerByPropertyId(@Param("propertyId") Long propertyId);
    
    List<Property> findByAddressContainingAndCityContainingAndStateContainingAndPropertyTypeAndRentAmountLessThan(String location,String city,String state,String propertyType,Double rentAmount);
}

