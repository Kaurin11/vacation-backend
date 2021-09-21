package com.example.vacation.controller;

import com.example.vacation.dto.request.CreateVacationPerYearRequest;
import com.example.vacation.dto.response.VacationPerYearResponse;
import com.example.vacation.service.IVacationPerYearService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vacation-per-year")
public class VacationPerYearController {

    private final IVacationPerYearService vacationPerYearService;

    public VacationPerYearController(IVacationPerYearService vacationPerYearService) {
        this.vacationPerYearService = vacationPerYearService;
    }

    @PostMapping("/{id}")
    public VacationPerYearResponse createVacationDays (@RequestBody CreateVacationPerYearRequest request, @PathVariable Long id) throws Exception{
           return vacationPerYearService.addVacationPerYear(request, id);
    }
}
