package com.example.hiringagency.service.impl;

import com.example.hiringagency.DAO.AdministratorMapper;
import com.example.hiringagency.domain.entity.Users;
import com.example.hiringagency.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    public AdministratorMapper adminMapper;

    @Override
    public void addStaff(String FirstName, String LastName, String Username, String Password, String PostalAddress, String PhoneNumber, String Email){
        adminMapper.addStaff(FirstName, LastName, Username, Password, PostalAddress, PhoneNumber, Email);
    }

    @Override
    public Integer maxId(){
        return adminMapper.selectMaxId();
    }

    @Override
    public List<Users> StaffList(){
        return adminMapper.selectAllStaff();
    }
}
