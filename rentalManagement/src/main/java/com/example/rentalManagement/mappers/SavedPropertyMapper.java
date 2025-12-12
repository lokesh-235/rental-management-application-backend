package com.example.rentalManagement.mappers;

import com.example.rentalManagement.dtos.SavedPropertyDto;
import com.example.rentalManagement.entities.SavedProperty;

public class SavedPropertyMapper {

    public static SavedPropertyDto toDto(SavedProperty saved) {
        if (saved == null) return null;

        SavedPropertyDto dto = new SavedPropertyDto();
        dto.setId(saved.getId());
        dto.setUserId(saved.getUser().getUserId());
        dto.setPropertyId(saved.getProperty().getPropertyId());
        return dto;
    }

    public static SavedProperty toEntity(SavedPropertyDto dto) {
        if (dto == null) return null;

        SavedProperty saved = new SavedProperty();
        saved.setId(dto.getId());
        // user and property will be set in service
        return saved;
    }
}
