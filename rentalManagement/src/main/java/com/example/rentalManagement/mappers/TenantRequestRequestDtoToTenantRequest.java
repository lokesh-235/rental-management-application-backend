package com.example.rentalManagement.mappers;

import com.example.rentalManagement.entities.Property;
import com.example.rentalManagement.entities.TenantRequest;
import com.example.rentalManagement.entities.User;

public class TenantRequestRequestDtoToTenantRequest {
	public static TenantRequest toTenantRequest(String message,Property property,User tenant) {
		TenantRequest tenantRequest = new TenantRequest();
		tenantRequest.setProperty(property);
		tenantRequest.setTenant(tenant);
		tenantRequest.setMessage(message);
		return tenantRequest;
	}
}
