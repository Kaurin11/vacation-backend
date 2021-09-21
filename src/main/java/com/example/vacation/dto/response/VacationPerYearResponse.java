package com.example.vacation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VacationPerYearResponse {

    private  Long id;

    private int vacationDay;

    private String year;
}
