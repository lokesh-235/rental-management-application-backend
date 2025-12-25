package com.example.rentalManagement.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.rentalManagement.dtos.UserDto;
import com.example.rentalManagement.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
	
	
	@GetMapping("/getUserDetails/{userId}")
	public ResponseEntity<UserDto> getUserDetails(@PathVariable Long userId) {
		return ResponseEntity.ok(userService.getUserByUserId(userId));
	}
	
}
