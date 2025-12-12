package com.example.rentalManagement.mappers;

import com.example.rentalManagement.dtos.LoginResponseDto;
import com.example.rentalManagement.entities.User;

public class UserToLoginResponseMapper {
	public static LoginResponseDto toDto(User user) {
		
		LoginResponseDto loginResponse =  new LoginResponseDto();
		loginResponse.setUserId(user.getUserId());
		loginResponse.setEmail(user.getEmail());
		loginResponse.setUserName(user.getFullName());
		loginResponse.setRole(user.getRole());
		return loginResponse;	
		
	}
}
