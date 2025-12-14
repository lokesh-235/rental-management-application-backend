package com.example.rentalManagement.mappers;

import java.util.List;

import com.example.rentalManagement.dtos.PropertyDto;
import com.example.rentalManagement.dtos.PropertyImageDto;
import com.example.rentalManagement.entities.Property;
import com.example.rentalManagement.entities.User;

public class PropertyMapper {

    public static PropertyDto toDto(Property property,List<PropertyImageDto> images) {
        if (property == null) return null;

        PropertyDto dto = new PropertyDto();
        dto.setPropertyId(property.getPropertyId());
        dto.setOwnerId(property.getOwner().getUserId());
        dto.setTitle(property.getTitle());
        dto.setDescription(property.getDescription());
        dto.setAddress(property.getAddress());
        dto.setCity(property.getCity());
        dto.setState(property.getState());
        dto.setRentAmount(property.getRentAmount());
        dto.setDepositAmount(property.getDepositAmount());
        dto.setPropertyType(property.getPropertyType());
        dto.setImages(images);
        
        return dto;
    }

    public static Property toEntity(PropertyDto dto,User owner) {
        if (dto == null) return null;

        Property property = new Property();
        property.setPropertyId(dto.getPropertyId());

        property.setOwner(owner);

        property.setTitle(dto.getTitle());
        property.setDescription(dto.getDescription());
        property.setAddress(dto.getAddress());
        property.setCity(dto.getCity());
        property.setState(dto.getState());
        property.setRentAmount(dto.getRentAmount());
        property.setDepositAmount(dto.getDepositAmount());
        property.setPropertyType(dto.getPropertyType());
        return property;
    }
}

