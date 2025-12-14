package com.example.rentalManagement.services;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.http.ResponseEntity;

import com.example.rentalManagement.dtos.PropertyDto;
import com.example.rentalManagement.dtos.PropertyRequestDto;
import com.example.rentalManagement.dtos.SearchPropertiesRequestDto;

public interface PropertyService {
	PropertyDto addProperty(PropertyDto propertyDto) ;
	 
	List<PropertyDto> getPropertiesByOwnerId(Long id);
	 
	PropertyDto updateProperty(PropertyDto propertyDto, Long propertyId);
	
	List<PropertyDto> getAllProperties();
	
	PropertyDto deleteProperty(Long propertyId);

	List<PropertyDto> searchProperties(SearchPropertiesRequestDto searchPropertiesRequestDto);
}
