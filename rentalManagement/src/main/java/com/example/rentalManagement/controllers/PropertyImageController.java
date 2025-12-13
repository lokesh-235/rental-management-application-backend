package com.example.rentalManagement.controllers;

import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.rentalManagement.dtos.PropertyImageDto;
import com.example.rentalManagement.dtos.PropertyImageRequestDto;
import com.example.rentalManagement.services.PropertyImageService;

@RestController
@RequestMapping("/api/properties/images")
@CrossOrigin("http://localhost:5173")
public class PropertyImageController {
	private PropertyImageService propertyImageService;
	
	public PropertyImageController(PropertyImageService propertyImageService) {
		this.propertyImageService = propertyImageService;
	}
	
	@PostMapping(
		    value = "/upload/{propertyId}"
//		    consumes = MediaType.MULTIPART_FORM_DATA_VALUE
		)
	public ResponseEntity<PropertyImageDto> uploadFile(@RequestParam MultipartFile file,@PathVariable Long propertyId) throws IOException{
		return ResponseEntity.ok(this.propertyImageService.uploadImage(file, propertyId));
	}
}
