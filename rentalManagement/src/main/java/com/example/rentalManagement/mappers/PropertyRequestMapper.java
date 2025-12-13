package com.example.rentalManagement.mappers;

import com.example.rentalManagement.dtos.PropertyRequestDto;
import com.example.rentalManagement.entities.Property;
import com.example.rentalManagement.entities.User;

public class PropertyRequestMapper {
	public static Property toEntity(PropertyRequestDto dto) {
		Property property = new Property();
		
		User owner = new User();
		owner.setUserId(dto.getOwnerId());
		property.setOwner(owner);
		
		property.setAddress(dto.getAddress());
		property.setCity(dto.getCity());
		property.setState(dto.getState());
		property.setDepositAmount(dto.getDepositAmount());
		property.setDescription(dto.getDescription());
		property.setRentAmount(dto.getRentAmount());
		property.setTitle(dto.getTitle());
		property.setPropertyType(dto.getPropertyType());
		
		return property;
	}
}
