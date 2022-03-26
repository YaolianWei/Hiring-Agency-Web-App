package com.example.hiringagency.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Data
@NoArgsConstructor
public class ScheduleDetails implements Serializable {
    @Column(name = "FirstName" )
    private String firstName;

    @Column(name = "LastName" )
    private String lastName;

    @Column(name = "Gender" )
    private Long gender;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "DateOfBirth" )
    private Date dateOfBirth;

    @Column(name = "ServiceAddress" )
    private String serviceAddress;

    @Column(name = "PatientPhone" )
    private Long patientPhone;

    @Column(name = "PatientEmail" )
    private String patientEmail;

    @Column(name = "ServiceEntryID" )
    private Long serviceEntryId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "Date" )
    private Date date;

    @Column(name = "Status" )
    private Long status;

    @JsonFormat(pattern = "HH:mm")
    @Column(name = "StartTime" )
    private Timestamp startTime;

    @JsonFormat(pattern = "HH:mm")
    @Column(name = "EndTime" )
    private Timestamp endTime;

    @Column(name = "CareRequestID" )
    private Long careRequestId;
}
