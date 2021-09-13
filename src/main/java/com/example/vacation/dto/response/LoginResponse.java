package com.example.vacation.dto.response;

import com.example.vacation.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {

    UserResponse user;

    String token;
}
