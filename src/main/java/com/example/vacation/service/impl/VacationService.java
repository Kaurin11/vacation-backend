package com.example.vacation.service.impl;

import com.example.vacation.dto.request.CreateVacationRequest;
import com.example.vacation.dto.response.VacationResponse;
import com.example.vacation.entity.Vacation;
import com.example.vacation.repository.IVacationRepository;
import com.example.vacation.service.IVacationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacationService implements IVacationService {

    private final IVacationRepository vacationRepository;

    public VacationService(IVacationRepository vacationRepository) {
        this.vacationRepository = vacationRepository;
    }

    @Override
    public VacationResponse getVacation(Long id) {
        return null;
    }

    @Override
    public List<VacationResponse> getAllVacations() {
        return null;
    }

    @Override
    public VacationResponse createVacation(CreateVacationRequest request) throws Exception {
        Vacation vacation = new Vacation();
        vacation.setDateFrom(request.getDateFrom());
        vacation.setDateTo(request.getDateTo());
        vacation.setDaysOff(request.getDaysOff());
        try{
            Vacation savedVacation = vacationRepository.save(vacation);
            return mapVacationToVacationResponse(savedVacation);
        }catch (Exception ex){
            throw new Exception("Error create Vacation");
        }
    }

    private VacationResponse mapVacationToVacationResponse(Vacation vacation){
        VacationResponse vacationResponse = new VacationResponse();
        vacationResponse.setId(vacation.getId());
        vacationResponse.setDateFrom(vacation.getDateFrom());
        vacationResponse.setDateTo(vacation.getDateTo());
        vacationResponse.setDaysOff(vacation.getDaysOff());

        return  vacationResponse;
    }
}
