package com.example.hiringagency.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Info implements Serializable {

    private String firstName;

    private String lastName;

    private String postalAddress;

    private Long phoneNumber;

    private String email;

}
