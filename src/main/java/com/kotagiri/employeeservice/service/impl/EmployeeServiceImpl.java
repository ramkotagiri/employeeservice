package com.kotagiri.employeeservice.service.impl;

import com.kotagiri.employeeservice.crud.AddressRepository;
import com.kotagiri.employeeservice.crud.EmployeeRepository;
import com.kotagiri.employeeservice.entity.Address;
import com.kotagiri.employeeservice.entity.Employee;
import com.kotagiri.employeeservice.pojo.AddressDTO;
import com.kotagiri.employeeservice.pojo.EmployeeDTO;
import com.kotagiri.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AddressRepository addressRepository;
    @Override
    public void saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee=new Employee();
        employee.setId(employeeDTO.getId());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setGender(employeeDTO.getGender());
        employee.setDateOfBirth(employeeDTO.getDateOfBirth());
        employee.setDepartment(employeeDTO.getDepartment());
        employee.setSalary(employeeDTO.getSalary());
        AddressDTO addressDTO=employeeDTO.getAddress();
        Address address=new Address();
        address.setStreetName(addressDTO.getStreetName());
        address.setStreetNo(addressDTO.getStreetNo());
        address.setHouseNo(addressDTO.getHouseNo());
        address.setState(addressDTO.getState());
        address.setCountry(addressDTO.getCountry());
        address.setRegion(addressDTO.getRegion());
        address.setZipCode(addressDTO.getZipCode());
        employee.setAddress(address);
        employeeRepository.save(employee);

    }

    @Override
    public EmployeeDTO getEmployeeById(String id) {
        EmployeeDTO employeeDTO=new EmployeeDTO();
        Optional<Employee> employee=employeeRepository.findById(id);
        populateEmployeeDTO(employeeDTO, employee);
        return employeeDTO;
    }

    private static void populateEmployeeDTO(EmployeeDTO employeeDTO, Optional<Employee> employee) {
        if(employee.isPresent())
        {
            Employee employeeRecord= employee.get();

            employeeDTO.setId(employeeRecord.getId());
            employeeDTO.setFirstName(employeeRecord.getFirstName());
            employeeDTO.setLastName(employeeRecord.getLastName());
            employeeDTO.setGender(employeeRecord.getGender());
            employeeDTO.setDateOfBirth(employeeRecord.getDateOfBirth());
            employeeDTO.setDepartment(employeeRecord.getDepartment());
            employeeDTO.setSalary(employeeRecord.getSalary());
            Address address=employeeRecord.getAddress();

            AddressDTO addressDTO=new AddressDTO();
            addressDTO.setStreetName(address.getStreetName());
            addressDTO.setStreetNo(address.getStreetNo());
            addressDTO.setHouseNo(address.getHouseNo());
            addressDTO.setState(address.getState());
            addressDTO.setCountry(address.getCountry());
            addressDTO.setRegion(address.getRegion());
            addressDTO.setZipCode(address.getZipCode());
            employeeDTO.setAddress(addressDTO);
        }
    }

    @Override
    public EmployeeDTO getEmployeeByFirstName(String firstName) {

        EmployeeDTO employeeDTO=new EmployeeDTO();
        Optional<Employee> employee=employeeRepository.findByFirstName(firstName);
        populateEmployeeDTO(employeeDTO, employee);
        return employeeDTO;
    }

    @Override
    public EmployeeDTO getEmployeeByFirstNameAndLastName(String firstName, String lastName) {
        EmployeeDTO employeeDTO=new EmployeeDTO();
        Optional<Employee> employee=employeeRepository.findByFirstNameAndLastName(firstName,lastName);
        populateEmployeeDTO(employeeDTO, employee);
        return employeeDTO;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeDTO> employeeDTOList=new ArrayList<>();
        Iterable<Employee> employees=employeeRepository.findAll();
        employees.forEach(employee -> {
            EmployeeDTO employeeDTO=new EmployeeDTO();
            populateEmployeeDTO(employeeDTO, Optional.of(employee));
            employeeDTOList.add(employeeDTO);
        });
        return employeeDTOList;
    }

    @Override
    public List<EmployeeDTO> getAllEmployeesByStreetName(String streetName) {
        List<EmployeeDTO> employeeDTOList=new ArrayList<>();
        Optional<List<Employee>> employees=employeeRepository.findByAddressStreetName(streetName);
        employees.get().forEach(employee -> {
            EmployeeDTO employeeDTO=new EmployeeDTO();
            populateEmployeeDTO(employeeDTO, Optional.of(employee));
            employeeDTOList.add(employeeDTO);
        });
        return employeeDTOList;
    }

    @Override
    public List<EmployeeDTO> getAllEmployeesByCountry(String country) {
        List<EmployeeDTO> employeeDTOList=new ArrayList<>();
        Optional<List<Employee>> employees=employeeRepository.findByAddressCountry(country);
        employees.get().forEach(employee -> {
            EmployeeDTO employeeDTO=new EmployeeDTO();
            populateEmployeeDTO(employeeDTO, Optional.of(employee));
            employeeDTOList.add(employeeDTO);
        });
        return employeeDTOList;
    }

    @Override
    public List<EmployeeDTO> getAllEmployeesByGenderAndDepartment(String gender, String department) {
        List<EmployeeDTO> employeeDTOList=new ArrayList<>();
        List<Employee> employees=employeeRepository.getEmployeeByGenderAndDepartment(gender,department);
        employees.forEach(employee -> {
            EmployeeDTO employeeDTO=new EmployeeDTO();
            populateEmployeeDTO(employeeDTO, Optional.of(employee));
            employeeDTOList.add(employeeDTO);
        });
        return employeeDTOList;
    }

    @Override
    public Address getAddressByEmployeeID(String id) {
        return addressRepository.getAddressByEmployeeID(id);
    }
}
