package com.example.vacation.repository;

import com.example.vacation.entity.VacationPerYear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVacationPerYearRepository extends JpaRepository<VacationPerYear, Long> {
}
