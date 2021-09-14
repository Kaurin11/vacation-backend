package com.example.vacation.repository;

import com.example.vacation.entity.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IVacationRepository extends JpaRepository<Vacation, Long> {

     Vacation findVacationById (Long id);

     // List<Vacation> findAllByDate (Date date);
}
