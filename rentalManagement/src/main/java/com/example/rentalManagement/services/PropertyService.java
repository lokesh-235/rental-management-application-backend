package com.example.rentalManagement.services;

import java.util.List;

import org.jspecify.annotations.Nullable;

import com.example.rentalManagement.dtos.PropertyDto;

public interface PropertyService {
	PropertyDto addProperty(PropertyDto property) ;
	 
	List<PropertyDto> getPropertiesByOwnerId(Long id);
	 
	PropertyDto updateProperty(PropertyDto propertyDto, Long propertyId);
	
	List<PropertyDto> getAllProperties();
	
	PropertyDto deleteProperty(Long propertyId);
}
