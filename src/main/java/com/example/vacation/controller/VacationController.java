package com.example.vacation.controller;

import com.example.vacation.dto.request.CreateVacationRequest;
import com.example.vacation.dto.response.VacationResponse;
import com.example.vacation.service.IVacationService;
import org.springframework.data.repository.query.Param;
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

    @PostMapping("/{id}")
    public VacationResponse createVacation(@RequestBody CreateVacationRequest request, @PathVariable Long id) throws Exception{
        return vacationService.createVacation(request, id);
    }

    @GetMapping("/{id}/user")
    public List<VacationResponse> getAllVacationForUser(@PathVariable Long id){
        return vacationService.getAllVacationsByUser(id);
    }

//    @GetMapping("/by-date")
//    public List<VacationResponse> getAllVacationsForDate(@Param("date") String date){
//        return vacationService.getAllVacationByDate(date);
//    }
}
