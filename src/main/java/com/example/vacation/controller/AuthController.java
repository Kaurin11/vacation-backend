package com.example.vacation.controller;

import com.example.vacation.dto.request.LoginRequest;
import com.example.vacation.dto.response.UserResponse;
import com.example.vacation.service.IUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final IUserService userService;

    public AuthController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public UserResponse login(@RequestBody LoginRequest loginRequest)throws Exception{
        return userService.login(loginRequest);
    }
}
