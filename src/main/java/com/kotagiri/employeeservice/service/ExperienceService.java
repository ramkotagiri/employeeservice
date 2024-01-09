package com.kotagiri.employeeservice.service;

import com.kotagiri.employeeservice.entity.Experience;

import java.util.List;

public interface ExperienceService {

    List<Experience> getExperienceByEmployeeId(String id);
}
