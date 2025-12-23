package com.example.rentalManagement.services;

import org.springframework.stereotype.Service;

import com.example.rentalManagement.services.publishers.PropertyEventPublisher;

@Service
public interface UpdatePropertiesAfterTenantRequestApprovalService {

    
//    private PropertyEventPublisher propertyEventPublisher;
//    
//    public TenantApprovalService(PropertyEventPublisher propertyEventPublisher) {
//    	this.propertyEventPublisher = propertyEventPublisher;
//    }
    
    

    void approveTenantRequest(Long requestId); 
}
