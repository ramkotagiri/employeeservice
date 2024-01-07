package com.kotagiri.employeeservice.service.impl;

import com.kotagiri.employeeservice.crud.CompanyRepository;
import com.kotagiri.employeeservice.entity.Company;
import com.kotagiri.employeeservice.pojo.CompanyDTO;
import com.kotagiri.employeeservice.pojo.EmployeeDTO;
import com.kotagiri.employeeservice.service.CompanyService;
import com.kotagiri.employeeservice.utility.EmployeeServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;
    @Override
    public CompanyDTO getCompanyById(String company) {
        Optional<Company> companyOptional=companyRepository.findById(company);
        CompanyDTO companyDTO=new CompanyDTO();
        if(companyOptional.isPresent())
        {
            Company company1=companyOptional.get();
            companyDTO.setCompany(company1.getCompany());

            List<EmployeeDTO> employeeDTOList=new ArrayList<>();

            if(!CollectionUtils.isEmpty(company1.getEmployees()))
            {
                company1.getEmployees().forEach(employee -> {
                    EmployeeDTO employeeDTO=new EmployeeDTO();
                    EmployeeServiceUtil.populateEmployeeDTO(employeeDTO,Optional.of(employee));
                    employeeDTOList.add(employeeDTO);
                });

            }
            companyDTO.setEmployees(employeeDTOList);

        }
        return companyDTO;
    }


}
