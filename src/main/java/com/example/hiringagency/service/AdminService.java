package com.example.hiringagency.service;

import com.example.hiringagency.domain.entity.Users;

public interface AdminService {
    void addStaff(String FirstName, String LastName, String Username, String Password, String PostalAddress, String PhoneNumber, String Email);

    Long sumUserNum();

}
