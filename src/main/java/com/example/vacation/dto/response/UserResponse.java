package com.example.vacation.dto.response;

import com.example.vacation.util.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private Long id;

    private String firstName;

    private String lastName;

    private String companyPosition;

    private int numberOfVacationDay;

    private UserType roll;

    private String username;
}
