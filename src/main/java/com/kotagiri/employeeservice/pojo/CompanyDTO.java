package com.kotagiri.employeeservice.pojo;

import lombok.Data;

import java.util.List;
@Data
public class CompanyDTO {

    private String company;
    private List<EmployeeDTO> employees;
}
