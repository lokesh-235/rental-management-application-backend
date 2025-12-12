package com.example.rentalManagement.mappers;

import com.example.rentalManagement.dtos.PropertyImageDto;
import com.example.rentalManagement.entities.PropertyImage;

public class PropertyImageMapper {

    public static PropertyImageDto toDto(PropertyImage img) {
        if (img == null) return null;

        PropertyImageDto dto = new PropertyImageDto();
        dto.setImageId(img.getImageId());
        dto.setPropertyId(img.getProperty().getPropertyId());
        dto.setImageUrl(img.getImageUrl());
        return dto;
    }

    public static PropertyImage toEntity(PropertyImageDto dto) {
        if (dto == null) return null;

        PropertyImage img = new PropertyImage();
        img.setImageId(dto.getImageId());
        img.setImageUrl(dto.getImageUrl());
        return img;
    }
}
