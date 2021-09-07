package com.example.vacation.service;

import com.example.vacation.dto.request.CreateAdminRequest;
import com.example.vacation.dto.request.CreateUserRequest;
import com.example.vacation.dto.request.LoginRequest;
import com.example.vacation.dto.response.UserResponse;

import java.util.List;

public interface IUserService {

    UserResponse getUser (Long id);

    UserResponse createUser (CreateUserRequest request) throws Exception;

    List<UserResponse> getAllUers();

    UserResponse creteAdmin (CreateAdminRequest request) throws Exception;

    UserResponse login (LoginRequest loginRequest) throws Exception;

}
