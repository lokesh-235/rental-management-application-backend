package com.example.rentalManagement.services;

import org.springframework.stereotype.Service;

@Service
public class TenantApprovalService {

    
    private PropertyEventPublisher propertyEventPublisher;
    
    public TenantApprovalService(PropertyEventPublisher propertyEventPublisher) {
    	this.propertyEventPublisher = propertyEventPublisher;
    }
    
    

    public void approveTenantRequest(Long requestId) {

        // 1️⃣ Approve request
        // 2️⃣ Create ActiveRental
        // 3️⃣ Update DB

//         🔥 Notify all clients
        propertyEventPublisher.notifyAvailablePropertiesRefresh();
    }
}
