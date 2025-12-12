//package com.example.rentalManagement.controllers;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.rentalManagement.dtos.LoginRequestDto;
//import com.example.rentalManagement.dtos.LoginResponseDto;
//import com.example.rentalManagement.services.UserService;
//
//@RestController
//@RequestMapping("/api/users")
//@CrossOrigin("*")
//public class UserController {
//	
//	private UserService userService;
//	
//	public UserController(UserService userService) {
//		this.userService = userService;
//	}
//	
//	
//	
////	@PostMapping("/login")
////	public ResponseEntity<LoginResponseDto> Login(@RequestBody LoginRequestDto loginRequestDto) {
////		System.out.println(loginRequestDto);
////		return ResponseEntity.ok(this.userService.Login(loginRequestDto));
////	}
////	
//	
//}
