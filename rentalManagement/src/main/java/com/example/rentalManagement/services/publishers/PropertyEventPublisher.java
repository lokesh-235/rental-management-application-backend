package com.example.rentalManagement.services.publishers;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class PropertyEventPublisher {

    
    private SimpMessagingTemplate messagingTemplate;
    
    public PropertyEventPublisher(SimpMessagingTemplate messagingTemplate) {
    	this.messagingTemplate = messagingTemplate;
    }

    public void notifyAvailablePropertiesRefresh() {
        messagingTemplate.convertAndSend(
            "/topic/available-properties",
            "REFRESH"
        );
    }
}

