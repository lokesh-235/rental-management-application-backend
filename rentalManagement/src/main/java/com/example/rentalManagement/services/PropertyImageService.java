package com.example.rentalManagement.services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.example.rentalManagement.dtos.PropertyImageDto;

public interface PropertyImageService {
	PropertyImageDto uploadImage(MultipartFile file,Long propertyId) throws IOException;
}
