package com.example.rentalManagement.dtos;

public class TenantRequestRequestDto {
	private Long propertyId;
	private Long tenantId;
	private String message;
	
	public TenantRequestRequestDto() {}
	
	

	public TenantRequestRequestDto(Long propertyId, Long tenantId, String message) {
		
		this.propertyId = propertyId;
		this.tenantId = tenantId;
		this.message = message;
	}



	public Long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
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
	
	
	
}
