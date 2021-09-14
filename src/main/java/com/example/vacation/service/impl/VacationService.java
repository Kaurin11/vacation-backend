package com.example.vacation.service.impl;

import com.example.vacation.dto.request.CreateVacationRequest;
import com.example.vacation.dto.response.VacationResponse;
import com.example.vacation.entity.User;
import com.example.vacation.entity.Vacation;
import com.example.vacation.repository.IUserRepository;
import com.example.vacation.repository.IVacationRepository;
import com.example.vacation.service.IVacationService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VacationService implements IVacationService {

    private final IVacationRepository vacationRepository;

    private final IUserRepository userRepository;

    public VacationService(IVacationRepository vacationRepository, IUserRepository userRepository) {
        this.vacationRepository = vacationRepository;
        this.userRepository = userRepository;
    }

    @Override
    public VacationResponse getVacation(Long id){
        Vacation vacation = vacationRepository.findVacationById(id);
        return mapVacationToVacationResponse(vacation);
    }

    @Override
    public List<VacationResponse> getAllVacations() {
        List<Vacation> vacations = vacationRepository.findAll();
        return vacations.stream()
                .map(vacation -> mapVacationToVacationResponse(vacation))
                .collect(Collectors.toList());
    }

    @Override
    public List<VacationResponse> getAllVacationsByUser(long id) {
        User user = userRepository.findUserById(id);
        List<Vacation> vacations = user.getVacations();

        // Ovo radi isto sto i return ispod
//        List<VacationResponse> responses = new ArrayList<>();
//
//        for (Vacation v: vacations) {
//            VacationResponse vacationResponse = mapVacationToVacationResponse(v);
//            responses.add(vacationResponse);
//        }
//        return responses;

        return vacations.stream()
                .map(vacation -> mapVacationToVacationResponse(vacation))
                .collect(Collectors.toList());
    }

//    @Override
//    public List<VacationResponse> getAllVacationByDate(String date) {
//        Date d = new Date(date);
//        List<Vacation> vacationsForDate = vacationRepository.findAllByDate(d);
//
//        return vacationsForDate.stream()
//                .map(vacation -> mapVacationToVacationResponse(vacation))
//                .collect(Collectors.toList());
//    }

    @Override
    public VacationResponse createVacation(CreateVacationRequest request, long id) throws Exception {
        Vacation vacation = new Vacation();
        User user = userRepository.findUserById(id);
        vacation.setDateFrom(request.getDateFrom());
        vacation.setDateTo(request.getDateTo());
        vacation.setDaysOff(request.getDaysOff());
        vacation.setUser(user);

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
