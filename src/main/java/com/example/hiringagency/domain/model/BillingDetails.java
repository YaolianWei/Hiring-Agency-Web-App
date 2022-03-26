package com.example.hiringagency.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class BillingDetails implements Serializable {

    private String patientFirstName;

    private String patientLastName;

    private String hpFirstName;

    private String hpLastName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @JsonFormat(pattern = "HH:mm")
    private Timestamp startTime;

    @JsonFormat(pattern = "HH:mm")
    private Timestamp endTime;

    private double amount;
}
