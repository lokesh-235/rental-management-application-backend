package com.example.rentalManagement.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rentalManagement.dtos.PropertyDto;
import com.example.rentalManagement.dtos.PropertyRequestDto;
import com.example.rentalManagement.services.PropertyService;

@RestController
@RequestMapping("/api/properties")
@CrossOrigin("http://localhost:5173")
public class PropertyController {
	private PropertyService propertyService;
	
	public PropertyController(PropertyService propertyService) {
		// TODO Auto-generated constructor stub
		this.propertyService = propertyService;
	}
	
	@PostMapping
	public ResponseEntity<PropertyDto> addProperty(@RequestBody PropertyRequestDto propertyRequest){
		PropertyDto savedPropertyDto = this.propertyService.addProperty(propertyRequest);
		return ResponseEntity.ok(savedPropertyDto);
		
	}
	
	@GetMapping
	public ResponseEntity<List<PropertyDto>> getAllProperties(){
		return ResponseEntity.ok(this.propertyService.getAllProperties());
	}
	
	@PutMapping("/{propertyId}")
	public ResponseEntity<PropertyDto> updateProperty(@RequestBody PropertyDto propertyDto,@PathVariable Long propertyId){
		PropertyDto savedPropertyDto = this.propertyService.updateProperty(propertyDto,propertyId);
		return ResponseEntity.ok(savedPropertyDto);
	}
	
	@DeleteMapping("/{propertyId}")
	public ResponseEntity<String> deleteProperty(@PathVariable Long propertyId){
		System.out.println("........."+propertyId);
		this.propertyService.deleteProperty(propertyId);
		return ResponseEntity.ok("deleted successfully");
	}
	
	@GetMapping("/owner/{id}")
	public ResponseEntity<List<PropertyDto>> getPropertiesById(@PathVariable Long id){
		
		return ResponseEntity.ok(this.propertyService.getPropertiesByOwnerId(id));
	}
}
