package com.kotagiri.employeeservice.service.impl;

import com.kotagiri.employeeservice.crud.AddressRepository;
import com.kotagiri.employeeservice.crud.EmployeeRepository;
import com.kotagiri.employeeservice.entity.Address;
import com.kotagiri.employeeservice.entity.Employee;
import com.kotagiri.employeeservice.pojo.AddressDTO;
import com.kotagiri.employeeservice.pojo.EmployeeDTO;
import com.kotagiri.employeeservice.service.EmployeeService;
import com.kotagiri.employeeservice.utility.EmployeeServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

        EmployeeServiceUtil.populateExperiencesFromDTOToEntity(employee,employeeDTO);
        EmployeeServiceUtil.populateCompanyFromDTOToEntity(employee,employeeDTO);
        employeeRepository.save(employee);

    }


    @Override
    public EmployeeDTO getEmployeeById(String id) {
        EmployeeDTO employeeDTO=new EmployeeDTO();
        Optional<Employee> employee=employeeRepository.findById(id);
        EmployeeServiceUtil.populateEmployeeDTO(employeeDTO, employee);
        return employeeDTO;
    }





    @Override
    public EmployeeDTO getEmployeeByFirstName(String firstName) {

        EmployeeDTO employeeDTO=new EmployeeDTO();
        Optional<Employee> employee=employeeRepository.findByFirstName(firstName);
        EmployeeServiceUtil.populateEmployeeDTO(employeeDTO, employee);
        return employeeDTO;
    }

    @Override
    public EmployeeDTO getEmployeeByFirstNameAndLastName(String firstName, String lastName) {
        EmployeeDTO employeeDTO=new EmployeeDTO();
        Optional<Employee> employee=employeeRepository.findByFirstNameAndLastName(firstName,lastName);
        EmployeeServiceUtil.populateEmployeeDTO(employeeDTO, employee);
        return employeeDTO;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeDTO> employeeDTOList=new ArrayList<>();
        Iterable<Employee> employees=employeeRepository.findAll();
        employees.forEach(employee -> {
            EmployeeDTO employeeDTO=new EmployeeDTO();
            EmployeeServiceUtil.populateEmployeeDTO(employeeDTO, Optional.of(employee));
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
            EmployeeServiceUtil.populateEmployeeDTO(employeeDTO, Optional.of(employee));
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
            EmployeeServiceUtil.populateEmployeeDTO(employeeDTO, Optional.of(employee));
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
            EmployeeServiceUtil.populateEmployeeDTO(employeeDTO, Optional.of(employee));
            employeeDTOList.add(employeeDTO);
        });
        return employeeDTOList;
    }

    @Override
    public Address getAddressByEmployeeID(String id) {
        return addressRepository.getAddressByEmployeeID(id);
    }
}
