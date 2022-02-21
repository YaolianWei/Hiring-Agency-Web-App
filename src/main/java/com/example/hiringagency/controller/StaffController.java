package com.example.hiringagency.controller;

import com.example.hiringagency.domain.entity.JobAdvertisements;
import com.example.hiringagency.domain.entity.Users;
import com.example.hiringagency.domain.model.HPInfo;
import com.example.hiringagency.service.StaffService;
import com.example.hiringagency.service.Utilities;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StaffController {

    @Autowired
    private StaffService staffService;

    @Autowired
    private Utilities utilities;

    @GetMapping("/setAd")
    @ResponseBody
    public Map<String,String> setAd(JobAdvertisements jobAdvertisements){
        Map<String, String> ret = new HashMap<String, String>();
        staffService.setAd(jobAdvertisements);

        ret.put("code", "200");
        ret.put("msg", "Set advertisement success.");
        return ret;
    }

    @GetMapping("/adList")
    public List<JobAdvertisements> getAdList(){
        return staffService.viewAllAds();
    }

    @GetMapping("/deleteAd")
    public Map<String, String> deleteAd(@Param("jobAdvertisementID") long jobAdvertisementID){
        Map<String, String> ret = new HashMap<String, String>();
        staffService.deleteAd(jobAdvertisementID);
        ret.put("code", "200");
        ret.put("msg", "Delete advertisement success.");
        return ret;
    }

    @GetMapping("/hireHP")
    public Map<String,String> hireHP(@Param("healthcareJobApplicationId") Long healthcareJobApplicationId){
        Map<String, String> ret = new HashMap<String, String>();
        HPInfo info = staffService.selectInfoById(healthcareJobApplicationId);

        String username = null;
        Long no = staffService.maxId();
        if(no < 10){
            username = info.getLastName() + '0' + no;
        }
        else username = info.getLastName() + no;

        String Password = utilities.randomPassword();
        utilities.sendEmail(username,info.getEmail(),Password);

        String pwd = utilities.getSalt(Password);

        staffService.addHPAccount(info.getFirstName(),info.getLastName(),username,pwd, info.getPostalAddress(), info.getPhoneNumber(), info.getEmail());

        Long userId = no + 1;
        staffService.updateUserId(userId,healthcareJobApplicationId);
        ret.put("code", "200");
        ret.put("msg", "Hire the healthcare professional success.");
        return ret;
    }

    @GetMapping("/allHP")
    public List<Users> allHP(){
        return staffService.allHP();
    }

}
