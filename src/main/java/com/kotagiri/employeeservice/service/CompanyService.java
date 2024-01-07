package com.kotagiri.employeeservice.service;

import com.kotagiri.employeeservice.entity.Company;
import com.kotagiri.employeeservice.pojo.CompanyDTO;

public interface CompanyService {

    CompanyDTO getCompanyById(String company);
}
