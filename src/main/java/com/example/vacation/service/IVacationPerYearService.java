package com.example.vacation.service;

import com.example.vacation.dto.request.CreateVacationPerYearRequest;
import com.example.vacation.dto.response.VacationPerYearResponse;

public interface IVacationPerYearService {

    VacationPerYearResponse addVacationPerYear (CreateVacationPerYearRequest request, long id) throws Exception;
}
