package com.kotagiri.employeeservice.pojo;

import lombok.Data;

import java.util.Date;

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
}
