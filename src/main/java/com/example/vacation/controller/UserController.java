package com.example.vacation.controller;

import com.example.vacation.dto.request.CreateAdminRequest;
import com.example.vacation.dto.request.CreateUserRequest;
import com.example.vacation.dto.response.UserResponse;
import com.example.vacation.service.IUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserResponse getUser (@PathVariable Long id){
        return userService.getUser(id);
    }

    @GetMapping
    public List<UserResponse> getAllUsers(){
        return userService.getAllUers();
    }

    @PostMapping
    public UserResponse createUser(@RequestBody CreateUserRequest request) throws Exception{
        return userService.createUser(request);
    }

    @PostMapping("/admin")
    public UserResponse createAdmin(@RequestBody CreateAdminRequest request) throws Exception{
        return userService.creteAdmin(request);
    }
}
