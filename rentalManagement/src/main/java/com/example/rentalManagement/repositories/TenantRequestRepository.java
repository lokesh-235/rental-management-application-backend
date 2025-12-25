package com.example.rentalManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rentalManagement.entities.TenantRequest;

import java.util.List;

public interface TenantRequestRepository extends JpaRepository<TenantRequest, Long> {

    List<TenantRequest> findByPropertyPropertyId(Long propertyId);

    List<TenantRequest> findByTenantUserId(Long tenantId);

    List<TenantRequest> findByStatus(TenantRequest.Status status);
    
    List<TenantRequest> findByPropertyOwnerUserIdOrderByRequestedAtDesc(Long id);
    
    Double findRentAmountByPropertyPropertyId(Long propertyId);

}

