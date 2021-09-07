package com.example.vacation.entity;

import com.example.vacation.util.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@Entity(name= "user_entity")
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String companyPosition;

    @Column
    private int numberOfVacationDay;

    @Column
    @Enumerated(EnumType.STRING)
    private UserType roll;

    @Column
    private String username;

    @Column
    private String password;
}
