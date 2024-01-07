package com.kotagiri.employeeservice.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class EmployeeDTO {


    private String id;

    private String firstName;

    private String lastName;

    private Date dateOfBirth;

    private String gender;

    private String department;

    private Double salary;

    private AddressDTO address;

    private List<ExperienceDTO> experiences;

    private List<CompanyDTO> companies;
}
