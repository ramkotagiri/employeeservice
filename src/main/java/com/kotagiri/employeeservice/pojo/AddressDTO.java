package com.kotagiri.employeeservice.pojo;

import lombok.Data;

@Data
public class AddressDTO {
    private String streetName;
    private String streetNo;

    private String houseNo;

    private String state;

    private String country;

    private String zipCode;

    private String region;

}
