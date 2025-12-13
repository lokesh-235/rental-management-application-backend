package com.example.rentalManagement.services.implementations;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.rentalManagement.dtos.PropertyImageDto;
import com.example.rentalManagement.entities.Property;
import com.example.rentalManagement.entities.PropertyImage;
import com.example.rentalManagement.mappers.PropertyImageMapper;
import com.example.rentalManagement.repositories.PropertyImageRepository;
import com.example.rentalManagement.repositories.PropertyRepository;
import com.example.rentalManagement.services.PropertyImageService;

@Service
public class PropertyImageServiceImplementation implements PropertyImageService{
	
	private PropertyRepository propertyRepository;
	private PropertyImageRepository propertyImageRepository;
	
	
	
	@Value("${file.upload-dir}")
	String uploadDir;
	
	public PropertyImageServiceImplementation(PropertyImageRepository propertyImageRepository, PropertyRepository propertyRepository) {
		this.propertyImageRepository = propertyImageRepository;
		this.propertyRepository = propertyRepository;
	}
	
	
	
	@Override
	public PropertyImageDto uploadImage(MultipartFile file,Long propertyId) throws IOException {
		// TODO Auto-generated method stub
		String subFolder = "property-"+propertyId;
		Path folderPath = Paths.get(uploadDir,subFolder);
		Files.createDirectories(folderPath);
		
		String fileName = System.currentTimeMillis() + file.getOriginalFilename();
		
		Path filePath = folderPath.resolve(fileName);
		Files.copy(file.getInputStream(), filePath,StandardCopyOption.REPLACE_EXISTING);
		
		System.out.println("uploaded successfully"+filePath.toString());
		
		String fileUrl = filePath.toString();
		PropertyImageDto propertyImageDto = saveFilePathToDB(fileUrl,propertyId);
		return propertyImageDto;
		
	}

	private PropertyImageDto saveFilePathToDB(String fileUrl,Long propertyId) {
		// TODO Auto-generated method stub
		PropertyImage propertyImage = new PropertyImage();
		
		Property property = this.propertyRepository
				.findById(propertyId)
				.orElseThrow(() -> new RuntimeException("Property Does not exist"));
		
		propertyImage.setImageUrl(fileUrl);
		propertyImage.setProperty(property);
		
		PropertyImage savedPropertyImage = propertyImageRepository.save(propertyImage);
		
		return PropertyImageMapper.toDto(savedPropertyImage);
		
		
	}

}
