package com.example.vacation.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class VacationPerYear extends BaseEntity {

    private int vacationDay;

    private String year;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "user_id" )
    private User user;
}
