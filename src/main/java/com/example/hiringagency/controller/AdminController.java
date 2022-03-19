package com.example.hiringagency.controller;

import com.example.hiringagency.domain.entity.Users;
import com.example.hiringagency.service.AdminService;
import com.example.hiringagency.service.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private Utilities utilities;

    @GetMapping("/staffList")
    public List<Users> getStaffList(){
        return adminService.StaffList();
    }

    @GetMapping("/addStaff")
    public Map<String,String> addStaff(String FirstName, String LastName, String PostalAddress, String PhoneNumber, String Email){
        Map<String, String> ret = new HashMap<>();
        boolean isCoNum = utilities.isCorrectNumFormat(PhoneNumber);
        if(!isCoNum){
            ret.put("code", "400");
            ret.put("msg", "Please enter phone number in the correct format.");
            return ret;
        }
        boolean isCoEmail = utilities.isCorrectEmaFormat(Email);
        if(!isCoEmail){
            ret.put("code", "401");
            ret.put("msg", "Please enter email in the correct format.");
            return ret;
        }

        String Username;
        int no = adminService.maxId();
        if(no < 10){
            Username = LastName + '0' + no;
        }
        else Username = LastName + no;

        String Password = utilities.randomPassword();
        utilities.sendEmail(Username,Email,Password);
        String pwd = utilities.getSalt(Password);
        adminService.addStaff(FirstName, LastName, Username, pwd, PostalAddress, PhoneNumber, Email);

        ret.put("code", "200");
        ret.put("msg", "Staff inserts success.");
        return ret;
    }


}
