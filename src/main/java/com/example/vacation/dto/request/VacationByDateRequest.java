package com.example.vacation.dto.request;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class VacationByDateRequest {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

}
