package com.kotagiri.employeeservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Experience {
    @GeneratedValue
    @Id
    private Integer id;
    @Column
    private String company;
    @Column
    private Date startDate;
    @Column
    private Date endDate;
    @Column
    private String technology;

}
