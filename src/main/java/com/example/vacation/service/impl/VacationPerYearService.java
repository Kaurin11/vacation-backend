package com.example.vacation.service.impl;

import com.example.vacation.dto.request.CreateVacationPerYearRequest;
import com.example.vacation.dto.response.VacationPerYearResponse;
import com.example.vacation.entity.User;
import com.example.vacation.entity.VacationPerYear;
import com.example.vacation.repository.IUserRepository;
import com.example.vacation.repository.IVacationPerYearRepository;
import com.example.vacation.service.IVacationPerYearService;
import org.springframework.stereotype.Service;

@Service
public class VacationPerYearService implements IVacationPerYearService {

    private final IUserRepository userRepository;

    private final IVacationPerYearRepository vacationPerYearRepository;

    public VacationPerYearService(IUserRepository userRepository, IVacationPerYearRepository vacationPerYearRepository) {
        this.userRepository = userRepository;
        this.vacationPerYearRepository = vacationPerYearRepository;
    }


    @Override
    public VacationPerYearResponse addVacationPerYear(CreateVacationPerYearRequest request, long id) throws Exception {
        VacationPerYear vacationPerYear = new VacationPerYear();
        User user = userRepository.findUserById(id);

        vacationPerYear.setYear(request.getYear());
        vacationPerYear.setVacationDay(request.getVacationDay());
        vacationPerYear.setUser(user);

        try{
            VacationPerYear savedVacationPerYear = vacationPerYearRepository.save(vacationPerYear);
            return mapVacationPerDayToVacationPerDayResponse(savedVacationPerYear);
        }catch (Exception ex){
            throw new Exception("Error adding Vacation Per Year");
        }
    }

    private VacationPerYearResponse mapVacationPerDayToVacationPerDayResponse(VacationPerYear vacationPerYear){
        VacationPerYearResponse vacationPerYearResponse = new VacationPerYearResponse();
        vacationPerYearResponse.setId(vacationPerYear.getId());
        vacationPerYearResponse.setYear(vacationPerYear.getYear());
        vacationPerYearResponse.setVacationDay(vacationPerYear.getVacationDay());

        return  vacationPerYearResponse;
    }
}
