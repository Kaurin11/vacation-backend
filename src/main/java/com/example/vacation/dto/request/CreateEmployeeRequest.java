package com.example.vacation.dto.request;

import lombok.Data;

@Data
public class CreateEmployeeRequest {

    private String firstName;

    private String lastName;

    private String companyPosition;

    private int numberOfVacationDay;

    private String username;

    private String password;
}
