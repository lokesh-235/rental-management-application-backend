package com.example.rentalManagement.mappers;

import com.example.rentalManagement.dtos.TenantRequestDto;
import com.example.rentalManagement.entities.TenantRequest;

public class TenantRequestMapper {

    public static TenantRequestDto toDto(TenantRequest req) {
        if (req == null) return null;

        TenantRequestDto dto = new TenantRequestDto();
        dto.setRequestId(req.getRequestId());
        
        dto.setProperty(PropertyMapper.toDto(req.getProperty(),null));
        dto.setTenantId(req.getTenant().getUserId());
        dto.setMessage(req.getMessage());
        dto.setStatus(req.getStatus());
        dto.setRequestedAt(req.getRequestedAt());
        return dto;
    }

    public static TenantRequest toEntity(TenantRequestDto dto) {
        if (dto == null) return null;

        TenantRequest req = new TenantRequest();
//        req.setRequestId(dto.getRequestId());
        req.setMessage(dto.getMessage());
        req.setStatus(dto.getStatus());
        return req;
    }
}

