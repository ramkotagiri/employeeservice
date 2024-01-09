package com.kotagiri.employeeservice.service.impl;


import com.kotagiri.employeeservice.crud.ExperienceRepository;
import com.kotagiri.employeeservice.entity.Experience;
import com.kotagiri.employeeservice.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceServiceImpl implements ExperienceService {
    @Autowired
    private ExperienceRepository experienceRepository;
    @Override
    public List<Experience> getExperienceByEmployeeId(String id) {
        return experienceRepository.findByExperienceEmployeeId(id);
    }
}
