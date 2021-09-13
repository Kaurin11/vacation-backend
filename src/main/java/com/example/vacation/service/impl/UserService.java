package com.example.vacation.service.impl;

import com.example.vacation.dto.request.CreateAdminRequest;
import com.example.vacation.dto.request.CreateUserRequest;
import com.example.vacation.dto.request.LoginRequest;
import com.example.vacation.dto.response.LoginResponse;
import com.example.vacation.dto.response.UserResponse;
import com.example.vacation.entity.User;
import com.example.vacation.repository.IUserRepository;
import com.example.vacation.service.IUserService;
import com.example.vacation.util.enums.UserType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    private final IUserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtTokenService jwtTokenService;

    public UserService(IUserRepository userRepository, PasswordEncoder passwordEncoder, JwtTokenService jwtTokenService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenService = jwtTokenService;
    }

    @Override
    public UserResponse getUser(Long id) {
        User user = userRepository.findUserById(id);
        return mapUserToUserResponse(user);
    }

    @Override
    public List<UserResponse> getAllUers() {
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(user -> mapUserToUserResponse(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse creteAdmin(CreateAdminRequest request) throws Exception {
        if(userRepository.findUserByUsername(request.getUsername()) != null){
            throw new Exception("Already exist user.");
        }
        User admin = new User();
        admin.setFirstName(request.getFirstName());
        admin.setLastName(request.getLastName());
        admin.setCompanyPosition(request.getCompanyPosition());
        admin.setNumberOfVacationDay(request.getNumberOfVacationDay());
        admin.setRoll(UserType.ADMIN);
        admin.setUsername(request.getUsername());
        admin.setPassword(passwordEncoder.encode(request.getPassword()));
        try{
            User savedAdmin = userRepository.save(admin);
            return mapUserToUserResponse(savedAdmin);
        }catch (Exception ex){
            throw new Exception("Error create Admin");
        }
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) throws Exception {
        User user = userRepository.findUserByUsername(loginRequest.getUsername());
        if(user == null){
            throw new Exception("User don't exist");
        }

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())){
            throw new Exception("Wrong password");
        }

        String token = jwtTokenService.generateToken(user.getId().toString());

        return returnLoginResponse(user, token);
    }

    @Override
    public UserResponse createUser(CreateUserRequest request) throws Exception {
        if(userRepository.findUserByUsername(request.getUsername()) != null){
            throw new Exception("Already exist user.");
        }
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setCompanyPosition(request.getCompanyPosition());
        user.setRoll(UserType.EMPLOYEE);
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        try{
         User savedUser =  userRepository.save(user);
         return mapUserToUserResponse(savedUser);
        }catch (Exception ex) {
            throw new Exception("Error create User");
        }
    }

    private UserResponse mapUserToUserResponse(User user){
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setCompanyPosition(user.getCompanyPosition());
        userResponse.setRoll(user.getRoll());
        userResponse.setNumberOfVacationDay(user.getNumberOfVacationDay());
        userResponse.setUsername(user.getUsername());

        return userResponse;
    }

    private LoginResponse returnLoginResponse(User user , String token){
        LoginResponse loginResponse = new LoginResponse();
        UserResponse userResponse = mapUserToUserResponse(user);
        loginResponse.setUser(userResponse);
        loginResponse.setToken(token);
        return  loginResponse;
    }
}
