package com.example.vacation.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Vacation extends BaseEntity {

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateFrom;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateTo;

    @Column
    private int daysOff ;

}
