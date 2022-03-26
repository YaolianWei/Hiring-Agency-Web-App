package com.example.hiringagency.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class BillingAccountInfo implements Serializable {

    private Long billingId;

    private Long serviceId;

    private Long careRequestId;

    private Long careTakerId;

    @Column(name = "FirstName" )
    private String ctFirstName;

    @Column(name = "LastName" )
    private String ctLastName;

    private String patientFirstName;

    private String patientLastName;

    @Column(name = "HourlyRate" )
    private Double hourlyRate;

    @Column(name = "PaidAmount" )
    private Double paidAmount;

    @Column(name = "AmountYetToPay" )
    private Double amountYetToPay;
}
