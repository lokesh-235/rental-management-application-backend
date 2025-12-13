package com.example.rentalManagement.services.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.rentalManagement.dtos.PropertyDto;
import com.example.rentalManagement.dtos.PropertyRequestDto;
import com.example.rentalManagement.entities.Property;
import com.example.rentalManagement.mappers.PropertyMapper;
import com.example.rentalManagement.mappers.PropertyRequestMapper;
import com.example.rentalManagement.repositories.PropertyRepository;
import com.example.rentalManagement.repositories.UserRepository;
import com.example.rentalManagement.services.PropertyService;

@Service
public class PropertyServiceImplementation implements PropertyService {
	
	private PropertyRepository propertyRepository;
	private UserRepository userRepository;

	public PropertyServiceImplementation(PropertyRepository propertyRepository,UserRepository userRepository) {
		this.propertyRepository = propertyRepository;
		this.userRepository = userRepository;
		
	}
	
	@Override
	public PropertyDto addProperty(PropertyRequestDto propertyRequest) {
		// TODO Auto-generated method stub
		Property property = PropertyRequestMapper.toEntity(propertyRequest);
	
		Property savedProperty = this.propertyRepository.save(property);
		
		return PropertyMapper.toDto(savedProperty);
	}

	@Override
	public List<PropertyDto> getPropertiesByOwnerId(Long id) {
		// TODO Auto-generated method stub
		List<Property> properties = this.propertyRepository.findByOwnerUserId(id);
		
		List<PropertyDto> propertyDtos = properties.stream()
				.map(PropertyMapper::toDto)
				.collect(Collectors.toList());
		
		return propertyDtos;
	}

	@Override
	public PropertyDto updateProperty(PropertyDto propertyDto,Long propertyId) {
		// TODO Auto-generated method stub
		propertyDto.setPropertyId(propertyId);
		
		Property property = PropertyMapper.toEntity(propertyDto);
		
		property.setOwner(this.userRepository
				.findById(propertyDto.getOwnerId()).orElseThrow(()->
				new RuntimeException("Owner does not exist")
		));
		
		System.out.println("Updated : "+property.getOwner());
		Property savedProperty = this.propertyRepository.save(property);
		return PropertyMapper.toDto(savedProperty);
	}

	@Override
	public List<PropertyDto> getAllProperties() {
		// TODO Auto-generated method stub
		List<Property> properties = this.propertyRepository.findAll();
		List<PropertyDto> propertyDtos = properties.stream()
				.map(PropertyMapper::toDto)
				.collect(Collectors.toList());
		System.out.println(propertyDtos);
		System.out.println("getting properties ...");
		return propertyDtos;
	}

	@Override
	public PropertyDto deleteProperty(Long propertyId) {
		// TODO Auto-generated method stub
		this.propertyRepository.deleteById(propertyId);
		return null;
	}
	
}
