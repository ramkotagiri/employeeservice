package com.kotagiri.employeeservice.controller;

import com.kotagiri.employeeservice.entity.Address;
import com.kotagiri.employeeservice.pojo.EmployeeDTO;
import com.kotagiri.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/employee")
    public ResponseEntity<String> insertEmployeeRecord(@RequestBody EmployeeDTO employeeDTO)
    {
        employeeService.saveEmployee(employeeDTO);
        return new ResponseEntity<String>("Employee Successfully Created/Updated",HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
            public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable String id)
    {
        return new ResponseEntity<>(employeeService.getEmployeeById(id),HttpStatus.OK);
    }

    @GetMapping("/employee/name/{firstName}")
    public ResponseEntity<EmployeeDTO> getEmployeeByName(@PathVariable String firstName)
    {
        return new ResponseEntity<>(employeeService.getEmployeeByFirstName(firstName),HttpStatus.OK);
    }

    @GetMapping("/employee/name/{firstName}/{lastName}")
    public ResponseEntity<EmployeeDTO> getEmployeeByFirstNameAndLastName(@PathVariable String firstName,@PathVariable String lastName)
    {
        return new ResponseEntity<>(employeeService.getEmployeeByFirstNameAndLastName(firstName,lastName),HttpStatus.OK);
    }

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees()
    {
        return new ResponseEntity<>(employeeService.getAllEmployees(),HttpStatus.OK);
    }

    @GetMapping("/getAllEmployeesByStreetName/{streetName}")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployeesByStreetName(@PathVariable String streetName)
    {
        return new ResponseEntity<>(employeeService.getAllEmployeesByStreetName(streetName),HttpStatus.OK);
    }

    @GetMapping("/getAllEmployeesByCountry/{country}")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployeesByCountry(@PathVariable String country)
    {
        return new ResponseEntity<>(employeeService.getAllEmployeesByCountry(country),HttpStatus.OK);
    }

    @GetMapping("/getAllEmployeesByGenderAndDepartment/{gender}/{department}")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployeesByGenderAndDepartment(@PathVariable String gender,@PathVariable String department)
    {
        return new ResponseEntity<>(employeeService.getAllEmployeesByGenderAndDepartment(gender,department),HttpStatus.OK);
    }

    @GetMapping("/getAddressByEmployeeId/{id}")
    public ResponseEntity<Address> getAddressByEmployeeId(@PathVariable String id)
    {
        return new ResponseEntity<>(employeeService.getAddressByEmployeeID(id),HttpStatus.OK);
    }
}
