package com.example.rentalManagement.mappers;

import com.example.rentalManagement.dtos.SignupRequestDto;
import com.example.rentalManagement.entities.User;

public class SignupRequestDtoToUserMapper {
	public static User toUser(SignupRequestDto signupRequestDto) {
		User user = new User();
		
		user.setFullName(signupRequestDto.getFullName());
		user.setEmail(signupRequestDto.getEmail());
		user.setPasswordHash(signupRequestDto.getPasswordHash());
		user.setPhone(signupRequestDto.getPhone());
		user.setRole(signupRequestDto.getRole());
		
		
		return user;
	}
}
