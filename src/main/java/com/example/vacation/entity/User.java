package com.example.vacation.entity;

import com.example.vacation.util.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL , orphanRemoval = true )
    private List<Vacation> vacations = new ArrayList<>();
}
