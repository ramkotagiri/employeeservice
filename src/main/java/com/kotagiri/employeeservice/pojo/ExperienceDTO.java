package com.kotagiri.employeeservice.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
public class ExperienceDTO {

    private String company;

    private Date startDate;

    private Date endDate;

    private String technology;

}
