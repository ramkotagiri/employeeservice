package com.kotagiri.employeeservice.crud;

import com.kotagiri.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,String> {
    Optional<Employee> findByFirstName(String firstName);
    Optional<Employee> findByFirstNameAndLastName(String firstName,String lastName);

    Optional<List<Employee>> findByAddressStreetName(String streetName);

    Optional<List<Employee>> findByAddressCountry(String streetName);

    @Query("select emp from Employee emp where emp.gender=?1 and emp.department=?2")
    List<Employee> getEmployeeByGenderAndDepartment(String gender,String department);

}
