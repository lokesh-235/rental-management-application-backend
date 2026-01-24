package com.example.rentalManagement.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rentalManagement.dtos.SignupRequestDto;
import com.example.rentalManagement.services.UserService;

@RestController
@RequestMapping("/api/user")
public class SignupController {
	private UserService userService;
	
	public SignupController(UserService userService) {
		// TODO Auto-generated constructor stub
		this.userService = userService;
	}
	
	@PostMapping("/signup")
	public String signUpUser(@RequestBody SignupRequestDto signupRequestDto) {
		return userService.addUser(signupRequestDto);
	}
}
