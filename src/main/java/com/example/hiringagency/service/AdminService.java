package com.example.hiringagency.service;

import com.example.hiringagency.domain.entity.Users;

import java.util.List;

public interface AdminService {
    void addStaff(String FirstName, String LastName, String Username, String Password, String PostalAddress, String PhoneNumber, String Email);

    Integer maxId();

    List<Users> StaffList();

}
