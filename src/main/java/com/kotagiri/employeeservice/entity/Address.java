package com.kotagiri.employeeservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue
    private Long pk;
    @Column
    private String streetName;
    @Column
    private String streetNo;
    @Column
    private String houseNo;
    @Column
    private String state;
    @Column
    private String country;
    @Column
    private String zipCode;
    @Column
    private String region;
}
