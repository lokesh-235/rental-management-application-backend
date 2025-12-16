package com.example.rentalManagement.controllers;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.rentalManagement.dtos.LoginRequestDto;
import com.example.rentalManagement.dtos.LoginResponseDto;
import com.example.rentalManagement.services.UserService;

@RestController
@RequestMapping("/api/users")
public class LoginController {

    @Autowired
    private UserService service;

    @PostMapping("/login")
    public Object login(@RequestBody LoginRequestDto req, HttpSession session) {

        try {
            LoginResponseDto dto = service.login(req);
            session.setAttribute("user", dto);
            return dto;

        } catch (Exception e) {
            return "Invalid credentials";
        }
    }

    @GetMapping("/current")
    public Object currentUser(HttpSession session) {
        Object user = session.getAttribute("user");
        return (user != null) ? user : "No user logged in";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
    	System.out.println("Session over");
        session.invalidate();
        return "Logged out";
    }
}

