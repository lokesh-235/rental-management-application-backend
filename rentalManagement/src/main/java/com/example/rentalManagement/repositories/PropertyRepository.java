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
    
    @Query("""
    	    SELECT p FROM Property p
    	    WHERE NOT EXISTS (
    	        SELECT 1 FROM ActiveRental ar
    	        WHERE ar.property.propertyId = p.propertyId
    	        AND ar.status = 'ACTIVE'
    	    )
    	    AND (:location IS NULL OR LOWER(p.address) LIKE LOWER(CONCAT('%', :location, '%')))
    	    AND (:city IS NULL OR LOWER(p.city) LIKE LOWER(CONCAT('%', :city, '%')))
    	    AND (:state IS NULL OR LOWER(p.state) LIKE LOWER(CONCAT('%', :state, '%')))
    	    AND (:propertyType IS NULL OR p.propertyType = :propertyType)
    	    AND (:rentAmount IS NULL OR p.rentAmount <= :rentAmount)
    	""")
    	List<Property> searchAvailableProperties(
    	        @Param("location") String location,
    	        @Param("city") String city,
    	        @Param("state") String state,
    	        @Param("propertyType") String propertyType,
    	        @Param("rentAmount") Double rentAmount
    	);
    
    String findTitleByPropertyId(Long propertyId);

}

