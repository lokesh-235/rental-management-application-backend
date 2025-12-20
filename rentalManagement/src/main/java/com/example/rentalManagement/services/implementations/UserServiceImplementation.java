package com.example.rentalManagement.services.implementations;

import org.springframework.stereotype.Service;

import com.example.rentalManagement.dtos.LoginRequestDto;
import com.example.rentalManagement.dtos.LoginResponseDto;
import com.example.rentalManagement.dtos.UserDto;
import com.example.rentalManagement.entities.User;
import com.example.rentalManagement.mappers.UserMapper;
import com.example.rentalManagement.mappers.UserToLoginResponseMapper;
import com.example.rentalManagement.repositories.UserRepository;
import com.example.rentalManagement.services.UserService;

@Service
public class UserServiceImplementation implements UserService{
	
	private UserRepository userRepository;
	
	public UserServiceImplementation(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public LoginResponseDto login(LoginRequestDto loginRequest) {
		// TODO Auto-generated method stub
		User user = this.userRepository
				.findByEmailAndPasswordHash(loginRequest.getEmail(), loginRequest.getPassword())
				.orElseThrow(()->new RuntimeException("User does not exist"));
		
		System.out.println(user);
		
		LoginResponseDto loginResponse = UserToLoginResponseMapper.toDto(user);
		
		return loginResponse;
		
	}

	@Override
	public UserDto getUserByUserId(Long userId) {
		// TODO Auto-generated method stub
		User user = this.userRepository.findById(userId).orElseThrow(()->new RuntimeException("User does not exist..."));
		
		return UserMapper.toDto(user);
	}
	
	

}
