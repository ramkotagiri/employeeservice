package com.kotagiri.employeeservice.service;

import com.kotagiri.employeeservice.entity.Address;
import com.kotagiri.employeeservice.pojo.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    public void saveEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployeeById(String id);
    EmployeeDTO getEmployeeByFirstName(String firstName);

    EmployeeDTO getEmployeeByFirstNameAndLastName(String firstName,String lastName);

    List<EmployeeDTO> getAllEmployees();

    List<EmployeeDTO> getAllEmployeesByStreetName(String streetName);

    List<EmployeeDTO> getAllEmployeesByCountry(String streetName);

    List<EmployeeDTO> getAllEmployeesByGenderAndDepartment(String gender,String department);

    Address getAddressByEmployeeID(String id);

}
