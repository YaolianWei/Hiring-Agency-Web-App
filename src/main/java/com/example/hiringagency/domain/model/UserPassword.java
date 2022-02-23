package com.example.hiringagency.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class UserPassword implements Serializable {

    @Column(name = "Username" )
    private String username;

    @Column(name = "Password" )
    private String password;
}
