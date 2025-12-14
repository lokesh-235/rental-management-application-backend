package com.example.rentalManagement.services;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.rentalManagement.dtos.PropertyImageDto;

public interface PropertyImageService {
	PropertyImageDto uploadImage(MultipartFile file,Long propertyId) throws IOException;
	List<PropertyImageDto> getImagesOfProperty(Long propertyId);
}
