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
    private long hpid;

    @Column(name = "FirstName" )
    private String firstName;

    @Column(name = "LastName" )
    private String lastName;

    @Column(name = "AmountPaid" )
    private double amountPaid;

    @Column(name = "AmountYetToPay" )
    private double amountYetToPay;
}
