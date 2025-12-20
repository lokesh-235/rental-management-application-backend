package com.example.rentalManagement.mappers;

import com.example.rentalManagement.dtos.ActiveRentalDto;
import com.example.rentalManagement.dtos.PropertyDto;
import com.example.rentalManagement.dtos.UserDto;
import com.example.rentalManagement.entities.ActiveRental;
import com.example.rentalManagement.entities.Property;
import com.example.rentalManagement.entities.User;


public class ActiveRentalMapper {

    public static ActiveRentalDto toDto(ActiveRental rental,PropertyDto property,UserDto tenant) {
        if (rental == null) return null;

        ActiveRentalDto dto = new ActiveRentalDto();
        dto.setRentalId(rental.getRentalId());
        dto.setProperty(property);
        dto.setTenantId(tenant.getUserId());
        dto.setStartDate(rental.getStartDate());
        dto.setEndDate(rental.getEndDate());
        dto.setMonthlyRent(rental.getMonthlyRent());
        dto.setStatus(rental.getStatus());
        return dto;
    }

    public static ActiveRental toEntity(ActiveRentalDto dto,User owner,UserDto tenant) {
        if (dto == null) return null;

        ActiveRental rental = new ActiveRental();
        rental.setRentalId(dto.getRentalId());

//        Property property = new Property();
//        property.setProperty(dto.getProperty());
        rental.setProperty(PropertyMapper.toEntity(dto.getProperty(), owner));

       
        rental.setTenant(UserMapper.toEntity(tenant));

        rental.setStartDate(dto.getStartDate());
        rental.setEndDate(dto.getEndDate());
        rental.setMonthlyRent(dto.getMonthlyRent());

        rental.setStatus(dto.getStatus());
        return rental;
    }
}

