package com.example.rentalManagement.services;

import java.util.List;

import org.jspecify.annotations.Nullable;

import com.example.rentalManagement.dtos.PropertyDto;
import com.example.rentalManagement.dtos.PropertyRequestDto;

public interface PropertyService {
	PropertyDto addProperty(PropertyRequestDto propertyRequest) ;
	 
	List<PropertyDto> getPropertiesByOwnerId(Long id);
	 
	PropertyDto updateProperty(PropertyDto propertyDto, Long propertyId);
	
	List<PropertyDto> getAllProperties();
	
	PropertyDto deleteProperty(Long propertyId);
}
