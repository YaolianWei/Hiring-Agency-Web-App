package com.example.hiringagency.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class HPAccountInfo implements Serializable {

    @Column(name = "HPAccountID" )
    private long hpAccountId;

    @Column(name = "HPID" )
    private long hpId;

    @Column(name = "FirstName" )
    private String firstName;

    @Column(name = "LastName" )
    private String lastName;

    @Column(name = "HourlyRate" )
    private String hourlyRate;

    @Column(name = "AmountPaid" )
    private double amountPaid;

    @Column(name = "AmountYetToPay" )
    private double amountYetToPay;
}
