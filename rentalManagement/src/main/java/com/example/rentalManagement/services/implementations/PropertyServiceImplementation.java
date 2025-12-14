package com.example.rentalManagement.services.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.rentalManagement.dtos.PropertyDto;
import com.example.rentalManagement.dtos.PropertyImageDto;
import com.example.rentalManagement.dtos.PropertyRequestDto;
import com.example.rentalManagement.dtos.SearchPropertiesRequestDto;
import com.example.rentalManagement.entities.Property;
import com.example.rentalManagement.entities.PropertyImage;
import com.example.rentalManagement.entities.User;
import com.example.rentalManagement.mappers.PropertyMapper;
import com.example.rentalManagement.mappers.PropertyRequestMapper;
import com.example.rentalManagement.repositories.PropertyImageRepository;
import com.example.rentalManagement.repositories.PropertyRepository;
import com.example.rentalManagement.repositories.UserRepository;
import com.example.rentalManagement.services.PropertyImageService;
import com.example.rentalManagement.services.PropertyService;

@Service
public class PropertyServiceImplementation implements PropertyService {
	
	private PropertyRepository propertyRepository;
	private UserRepository userRepository;
	private PropertyImageService propertyImageService;

	public PropertyServiceImplementation(PropertyRepository propertyRepository,UserRepository userRepository,PropertyImageService propertyImageService) {
		this.propertyRepository = propertyRepository;
		this.userRepository = userRepository;
		this.propertyImageService = propertyImageService;
	}
	
	@Override
	public PropertyDto addProperty(PropertyDto propertyDto) {
		// TODO Auto-generated method stub
		System.out.println(propertyDto.getOwnerId());
		
		User owner = this.userRepository
				.findById(propertyDto.getOwnerId()).orElseThrow(()->
				new RuntimeException("Owner does not exist"));
		System.out.println(owner);
		Property property = PropertyMapper.toEntity(propertyDto,owner);
		
		
		
		System.out.println("Updated : "+property.getOwner());
		Property savedProperty = this.propertyRepository.save(property);
		return PropertyMapper.toDto(savedProperty,null);
	}

	@Override
	public List<PropertyDto> getPropertiesByOwnerId(Long id) {
		// TODO Auto-generated method stub
		List<Property> properties = this.propertyRepository.findByOwnerUserId(id);
		
		
		List<PropertyDto> propertyDtos = properties.stream()
				.map((Property property)-> PropertyMapper.toDto(property, this.propertyImageService.getImagesOfProperty(property.getPropertyId())))
				.collect(Collectors.toList());
		
		
		return propertyDtos;
	}

	@Override
	public PropertyDto updateProperty(PropertyDto propertyDto,Long propertyId) {
		// TODO Auto-generated method stub
//		propertyDto.setPropertyId(propertyId);
		
		User owner = this.userRepository
				.findById(propertyDto.getOwnerId()).orElseThrow(()->
				new RuntimeException("Owner does not exist"));
		
		Property property = PropertyMapper.toEntity(propertyDto,owner);
		
		
		
		System.out.println("Updated : "+property.getOwner());
		Property savedProperty = this.propertyRepository.save(property);
		return PropertyMapper.toDto(savedProperty,this.propertyImageService.getImagesOfProperty(propertyId));
	}

	@Override
	public List<PropertyDto> getAllProperties() {
		// TODO Auto-generated method stub
		List<Property> properties = this.propertyRepository.findAll();
		
		List<PropertyDto> propertyDtos = properties.stream()
				.map((Property property)-> 
				PropertyMapper.toDto(property
						, this.propertyImageService.getImagesOfProperty(property.getPropertyId())))
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

	@Override
	public List<PropertyDto> searchProperties(SearchPropertiesRequestDto searchPropertiesRequestDto) {
		// TODO Auto-generated method stub
		String location = searchPropertiesRequestDto.getLocation();
		String propertyType = searchPropertiesRequestDto.getPropertyType();
		String city = searchPropertiesRequestDto.getCity();
		String state = searchPropertiesRequestDto.getState();
		Double maxRentAmount = searchPropertiesRequestDto.getMaxRentAmount();
		List<Property> properties = this.propertyRepository.findByAddressContainingAndCityContainingAndStateContainingAndPropertyTypeAndRentAmountLessThan(location,city,state,propertyType,maxRentAmount);
		
		List<PropertyDto> propertyDtos = properties.stream()
				.map((Property property)-> 
				PropertyMapper.toDto(property
						, this.propertyImageService.getImagesOfProperty(property.getPropertyId())))
				.collect(Collectors.toList());
		
		System.out.println(propertyDtos);
		System.out.println("getting propertis ...");
		return propertyDtos;
	}
	
}
