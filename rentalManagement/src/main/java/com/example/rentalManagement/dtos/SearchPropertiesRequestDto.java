package com.example.rentalManagement.dtos;

public class SearchPropertiesRequestDto {
	private String location;
	private String city;
	private String state;
	private String propertyType;
	private Double maxRentAmount;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPropertyType() {
		return propertyType;
	}
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
	public Double getMaxRentAmount() {
		return maxRentAmount;
	}
	public void setMaxRentAmount(Double maxRentAmount) {
		this.maxRentAmount = maxRentAmount;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
