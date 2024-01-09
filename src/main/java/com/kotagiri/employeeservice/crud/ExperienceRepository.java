package com.kotagiri.employeeservice.crud;

import com.kotagiri.employeeservice.entity.Experience;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienceRepository extends CrudRepository<Experience,Integer> {


    List<Experience> findByExperienceEmployeeId(String id);
}
