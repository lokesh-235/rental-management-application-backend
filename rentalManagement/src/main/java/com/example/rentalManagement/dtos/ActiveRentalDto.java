package com.example.rentalManagement.dtos;

import java.time.LocalDate;

import com.example.rentalManagement.entities.ActiveRental.Status;

public class ActiveRentalDto {
    private Long rentalId;
    private Long propertyId;
    private Long tenantId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double monthlyRent;
    private Status status;
	public Long getRentalId() {
		return rentalId;
	}
	public void setRentalId(Long rentalId) {
		this.rentalId = rentalId;
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
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public Double getMonthlyRent() {
		return monthlyRent;
	}
	public void setMonthlyRent(Double monthlyRent) {
		this.monthlyRent = monthlyRent;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
    
    
}

