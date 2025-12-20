package com.example.rentalManagement.services;

import com.example.rentalManagement.dtos.LoginRequestDto;
import com.example.rentalManagement.dtos.LoginResponseDto;
import com.example.rentalManagement.dtos.UserDto;

public interface UserService {
	LoginResponseDto login(LoginRequestDto loginRequest);
	
	UserDto getUserByUserId(Long userId);
}
