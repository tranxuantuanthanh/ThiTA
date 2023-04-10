package com.thanh.ThiTA.entity;

import lombok.*;

import java.util.Date;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
    private int employeeId;
    private String lastname;
    private String firstname;
    private String title;
    private String titleOfCourtesy;
    private Date birthDate;
    private Date hireDate;
    private String address;
    private String city;
    private String region;
    private String postalCode;
    private String country;
    private String phone;
    private String extension;
    private String mobile;
    private String email;
    private String password;
    private String notes;
    private Optional<Integer> mgrId;
    private String photoPath;
}
