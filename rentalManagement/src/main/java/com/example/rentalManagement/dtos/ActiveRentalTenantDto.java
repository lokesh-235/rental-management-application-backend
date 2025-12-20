package com.example.rentalManagement.dtos;

import java.util.ArrayList;
import java.util.List;

public class ActiveRentalTenantDto {
    private Long tenantId;
    private String fullName;
    private String email;
    private String phone;
    
    private List<ActiveRentalDto> rentals = new ArrayList<>();
    
	
	public Long getTenantId() {
		return tenantId;
	}
	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public List<ActiveRentalDto> getRentals() {
		return rentals;
	}
	public void setRentals(List<ActiveRentalDto> rentals) {
		this.rentals = rentals;
	}
    
    
}

