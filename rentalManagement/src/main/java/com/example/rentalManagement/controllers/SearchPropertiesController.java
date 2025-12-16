package com.example.rentalManagement.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rentalManagement.dtos.PropertyDto;
import com.example.rentalManagement.dtos.SearchPropertiesRequestDto;
import com.example.rentalManagement.services.PropertyService;

@RequestMapping("/api/properties")
@RestController
public class SearchPropertiesController {
	private PropertyService propertyService;
	
	public SearchPropertiesController(PropertyService propertyService) {
		this.propertyService = propertyService;
	}
	
	@PostMapping("/searchProperties")
	public ResponseEntity<List<PropertyDto>> searchProperties(@RequestBody SearchPropertiesRequestDto searchPropertiesRequestDto){
		return ResponseEntity.ok(propertyService.searchProperties(searchPropertiesRequestDto));
		
	}
}
