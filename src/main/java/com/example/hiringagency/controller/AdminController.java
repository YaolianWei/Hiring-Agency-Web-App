package com.example.hiringagency.controller;

import com.example.hiringagency.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/addStaff")
    public Map<String,String> addStaff(String FirstName, String LastName, String PostalAddress, String PhoneNumber, String Email){
        Map<String, String> ret = new HashMap<String, String>();
        if(FirstName == null){
            ret.put("type", "error");
            ret.put("msg", "Please enter correct information.");
            return ret;
        }

        String Username = null;
        Long no = adminService.sumUserNum();
        if(no < 10){
            Username = FirstName + '0' + no;
        }
        else Username = FirstName + no;

        String pwd = randomPassword();
        String Password = pwd;
        adminService.addStaff(FirstName, LastName, Username, Password, PostalAddress, PhoneNumber, Email);

        ret.put("type", "success");
        ret.put("msg", "Staff inserts success.");
        return ret;
    }

    public static String randomPassword(){
        String str1 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String str2 = "~!@#$%^&*+";
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i= 0; i < 6; i++){
            int number = random.nextInt(52);
            stringBuffer.append(str1.charAt(number));
        }
        int num = random.nextInt(10);
        stringBuffer.append(str2.charAt(num));
        return stringBuffer.toString();
    }
}