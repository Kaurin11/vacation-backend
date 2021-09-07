package com.example.vacation.repository;

import com.example.vacation.entity.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVacationRepository extends JpaRepository<Vacation, Long> {
}
