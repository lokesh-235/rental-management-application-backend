package com.example.rentalManagement.services.implementations;

import org.springframework.stereotype.Service;

import com.example.rentalManagement.services.TenantRequestApprovalService;
import com.example.rentalManagement.services.publishers.PropertyEventPublisher;

@Service
public class TenantRequestApprovalServiceImplementation implements TenantRequestApprovalService {
	
	PropertyEventPublisher propertyEventPublisher;
	
	public TenantRequestApprovalServiceImplementation(PropertyEventPublisher propertyEventPublisher) {
		this.propertyEventPublisher = propertyEventPublisher;
	}
	
	@Override
	public void approveTenantRequest(Long requestId) {
		// TODO Auto-generated method stub
	        
	        propertyEventPublisher.notifyAvailablePropertiesRefresh();
	}
	
}
