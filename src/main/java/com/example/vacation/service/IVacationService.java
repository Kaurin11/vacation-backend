package com.example.vacation.service;

import com.example.vacation.dto.request.CreateVacationRequest;
import com.example.vacation.dto.response.VacationResponse;

import java.util.List;

public interface IVacationService {

    VacationResponse getVacation (Long id);

    VacationResponse createVacation (CreateVacationRequest request, long id) throws Exception;

    List<VacationResponse> getAllVacations();

    List<VacationResponse> getAllVacationsByUser(long id);

    // List<VacationResponse> getAllVacationByDate(String date);
}
