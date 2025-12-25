package com.example.rentalManagement.dtos;


import java.time.LocalDateTime;

import com.example.rentalManagement.entities.TenantRequest.Status;

public class TenantRequestDto {
    private Long requestId;
    private PropertyDto propertyDto;
    private Long tenantId;
    private String message;
    private Status status;
    private LocalDateTime requestedAt;
    
	public Long getRequestId() {
		return requestId;
	}
	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}
	public PropertyDto getProperty() {
		return propertyDto;
	}
	public void setProperty(PropertyDto propertyDto) {
		this.propertyDto = propertyDto;
	}
	public Long getTenantId() {
		return tenantId;
	}
	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public LocalDateTime getRequestedAt() {
		return requestedAt;
	}
	public void setRequestedAt(LocalDateTime requestedAt) {
		this.requestedAt = requestedAt;
	}
    
    
}

