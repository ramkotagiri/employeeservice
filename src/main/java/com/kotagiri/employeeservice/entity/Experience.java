package com.kotagiri.employeeservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@NamedNativeQuery(name="Experience.findByExperienceEmployeeId",query="select exp.* from experience exp join employee_experience eexp on eexp.experience_id=exp.id join employee e on e.id=eexp.employee_id where e.id=?1",resultClass = Experience.class)
public class Experience {
    @GeneratedValue
    @Id
    private Integer id;
    @Column
    private String company;
    @Column
    private Date startDate;
    @Column
    private Date endDate;
    @Column
    private String technology;

}
