package com.kotagiri.employeeservice.crud;

import com.kotagiri.employeeservice.entity.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<Company, String> {
}
