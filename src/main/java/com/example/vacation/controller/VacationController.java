package com.example.vacation.controller;

import com.example.vacation.dto.request.CreateVacationRequest;
import com.example.vacation.dto.response.VacationResponse;
import com.example.vacation.service.IVacationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacation")
public class VacationController {

    private final IVacationService vacationService;

    public VacationController(IVacationService vacationService) {
        this.vacationService = vacationService;
    }

    @GetMapping("/{id}")
    public VacationResponse getVacation (@PathVariable Long id){
        return vacationService.getVacation(id);
    }

    @GetMapping
    public List<VacationResponse> getAllVacation(){
        return vacationService.getAllVacations();
    }

    @PostMapping
    public VacationResponse createVacation(@RequestBody CreateVacationRequest request) throws Exception{
        return vacationService.createVacation(request);
    }
}
