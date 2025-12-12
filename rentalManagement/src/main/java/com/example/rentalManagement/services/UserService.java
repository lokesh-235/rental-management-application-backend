package com.example.rentalManagement.services;

import com.example.rentalManagement.dtos.LoginRequestDto;
import com.example.rentalManagement.dtos.LoginResponseDto;

public interface UserService {
	LoginResponseDto login(LoginRequestDto loginRequest);
}
