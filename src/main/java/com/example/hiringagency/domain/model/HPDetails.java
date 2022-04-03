package com.example.hiringagency.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class HPDetails implements Serializable {

    @Column(name = "UserID" )
    private Long userId;

    @Column(name = "FirstName" )
    private String firstName;

    @Column(name = "LastName" )
    private String lastName;

    @Column(name = "Username" )
    private String username;

    @Column(name = "PostalAddress" )
    private String postalAddress;

    @Column(name = "PhoneNumber" )
    private Long phoneNumber;

    @Column(name = "Email" )
    private String email;

    @Column(name = "HourlyRate" )
    private Double hourlyRate;

    @Column(name = "ServiceType" )
    private Long serviceType;

    @Column(name = "Gender" )
    private Long gender;

    @Column(name = "DateOfBirth" )
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    @Column(name = "Degree" )
    private Long degree;

    @Column(name = "SSN" )
    private String ssn;

    @Column(name = "EducationQualifications" )
    private String educationQualifications;

    @Column(name = "YearsExperience" )
    private Long yearsExperience;
}
