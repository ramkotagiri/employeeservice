package com.kotagiri.employeeservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Employee {
    @Id
    private String id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private Date dateOfBirth;
    @Column
    private String gender;
    @Column
    private String department;
    @Column
    private Double salary;

    @OneToOne(orphanRemoval = true,
            cascade = CascadeType.ALL)
    private Address address;
}
