package com.example.vacation.dto.request;

import lombok.Data;

@Data
public class CreateVacationPerYearRequest {

    private int vacationDay;

    private String year;
}
