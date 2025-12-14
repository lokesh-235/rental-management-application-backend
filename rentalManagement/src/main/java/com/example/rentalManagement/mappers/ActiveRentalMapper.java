package com.example.rentalManagement.mappers;

import com.example.rentalManagement.dtos.ActiveRentalDto;
import com.example.rentalManagement.entities.ActiveRental;
import com.example.rentalManagement.entities.Property;
import com.example.rentalManagement.entities.User;

public class ActiveRentalMapper {

    public static ActiveRentalDto toDto(ActiveRental rental) {
        if (rental == null) return null;

        ActiveRentalDto dto = new ActiveRentalDto();
        dto.setRentalId(rental.getRentalId());
        dto.setPropertyId(rental.getProperty().getPropertyId());
        dto.setTenantId(rental.getTenant().getUserId());
        dto.setStartDate(rental.getStartDate());
        dto.setEndDate(rental.getEndDate());
        dto.setMonthlyRent(rental.getMonthlyRent());
        dto.setStatus(rental.getStatus());
        return dto;
    }

    public static ActiveRental toEntity(ActiveRentalDto dto) {
        if (dto == null) return null;

        ActiveRental rental = new ActiveRental();
        rental.setRentalId(dto.getRentalId());

        Property property = new Property();
        property.setPropertyId(dto.getPropertyId());
        rental.setProperty(property);

        User tenant = new User();
        tenant.setUserId(dto.getTenantId());
        rental.setTenant(tenant);

        rental.setStartDate(dto.getStartDate());
        rental.setEndDate(dto.getEndDate());
        rental.setMonthlyRent(dto.getMonthlyRent());

        rental.setStatus(dto.getStatus());
        return rental;
    }
}

