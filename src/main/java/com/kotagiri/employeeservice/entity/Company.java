package com.kotagiri.employeeservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Company {

    @Id
    private String company;

    @ManyToMany( mappedBy = "companies")
    private List<Employee> employees;
}
