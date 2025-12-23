package com.example.rentalManagement.services.implementations;

import org.springframework.stereotype.Service;
import com.example.rentalManagement.services.UpdatePropertiesAfterTenantRequestApprovalService;
import com.example.rentalManagement.services.publishers.PropertyEventPublisher;

@Service
public class UpdatePropertiesAfterTenantRequestApprovalServiceImplementation implements UpdatePropertiesAfterTenantRequestApprovalService {
	
	PropertyEventPublisher propertyEventPublisher;
	
	public UpdatePropertiesAfterTenantRequestApprovalServiceImplementation(PropertyEventPublisher propertyEventPublisher) {
		this.propertyEventPublisher = propertyEventPublisher;
	}
	
	@Override
	public void approveTenantRequest(Long requestId) {
		// TODO Auto-generated method stub
	        
	        propertyEventPublisher.notifyAvailablePropertiesRefresh();
	}
	
}
