package com.kotagiri.employeeservice.utility;

import com.kotagiri.employeeservice.entity.Address;
import com.kotagiri.employeeservice.entity.Company;
import com.kotagiri.employeeservice.entity.Employee;
import com.kotagiri.employeeservice.entity.Experience;
import com.kotagiri.employeeservice.pojo.AddressDTO;
import com.kotagiri.employeeservice.pojo.CompanyDTO;
import com.kotagiri.employeeservice.pojo.EmployeeDTO;
import com.kotagiri.employeeservice.pojo.ExperienceDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeServiceUtil {

    public static void populateCompanyFromDTOToEntity(Employee employee, EmployeeDTO employeeDTO) {

        List<Company> companies=new ArrayList<>();
        employeeDTO.getCompanies().forEach(companyDTO -> {
            Company company=new Company();
            company.setCompany(companyDTO.getCompany());
            companies.add(company);
        });
        employee.setCompanies(companies);
    }

    public static void populateCompanyFromEntityToDTO( EmployeeDTO employeeDTO,Employee employee) {

        List<CompanyDTO> companies=new ArrayList<>();
        employee.getCompanies().forEach(company -> {
            CompanyDTO companyDTO=new CompanyDTO();
            companyDTO.setCompany(company.getCompany());
            companies.add(companyDTO);
        });
        employeeDTO.setCompanies(companies);
    }
    public static void populateExperiencesFromDTOToEntity(Employee employee, EmployeeDTO employeeDTO)
    {
        List<Experience> experiences=new ArrayList<>();
        employeeDTO.getExperiences().forEach(experienceDTO -> {
            Experience experience=new Experience();
            experience.setCompany(experienceDTO.getCompany());
            experience.setTechnology(experienceDTO.getTechnology());
            experience.setStartDate(experienceDTO.getStartDate());
            experience.setEndDate(experienceDTO.getEndDate());

            experiences.add(experience);
        });
        employee.setExperience(experiences);
    }

    public static void populateExperiencesFromEntityToDTO(EmployeeDTO employeeDTO,Employee employee)
    {
        List<ExperienceDTO> experiences=new ArrayList<>();
        employee.getExperience().forEach(experience -> {
            ExperienceDTO experienceDTO=new ExperienceDTO();
            experienceDTO.setCompany(experience.getCompany());
            experienceDTO.setTechnology(experience.getTechnology());
            experienceDTO.setStartDate(experience.getStartDate());
            experienceDTO.setEndDate(experience.getEndDate());

            experiences.add(experienceDTO);
        });
        employeeDTO.setExperiences(experiences);
    }

    public static void populateAddressFromEntityToDTO(EmployeeDTO employeeDTO, Address address) {
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

    public static  void populateEmployeeDTO(EmployeeDTO employeeDTO, Optional<Employee> employee) {
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

            EmployeeServiceUtil.populateAddressFromEntityToDTO(employeeDTO, address);

            EmployeeServiceUtil.populateExperiencesFromEntityToDTO(employeeDTO,employeeRecord);

            EmployeeServiceUtil.populateCompanyFromEntityToDTO(employeeDTO,employeeRecord);
        }
    }
}
