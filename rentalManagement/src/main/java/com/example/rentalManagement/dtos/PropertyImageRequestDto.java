package com.example.rentalManagement.dtos;

import org.springframework.web.multipart.MultipartFile;

public class PropertyImageRequestDto {
	private Long propertyId;
	
	private MultipartFile file;
	public Long getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
}
