package com.example.hiringagency.controller;

import com.example.hiringagency.domain.entity.HealthcareJobApplication;
import com.example.hiringagency.domain.entity.ServiceEntries;
import com.example.hiringagency.service.HPService;
import com.example.hiringagency.service.Utilities;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HPController {

    @Autowired
    private HPService hpService;

    @Autowired
    private Utilities utilities;

    @PostMapping("/addHP")
    public Map<String,String> addHP(@RequestBody HealthcareJobApplication healthcareJobApplication){
        Map<String, String> ret = new HashMap<>();
        boolean isCoNum = utilities.isCorrectNumFormat(Long.toString(healthcareJobApplication.getPhoneNumber()));
        if(!isCoNum){
            ret.put("code", "400");
            ret.put("msg", "Please enter phone number in the correct format.");
            return ret;
        }
        boolean isCoEmail = utilities.isCorrectEmaFormat(healthcareJobApplication.getEmail());
        if(!isCoEmail){
            ret.put("code", "401");
            ret.put("msg", "Please enter email in the correct format.");
            return ret;
        }
        boolean hasSet = hpService.setHP(healthcareJobApplication);
        if (hasSet){
            ret.put("code", "200");
            ret.put("msg", "Apply success.");
            return ret;
        } else {
            ret.put("code", "201");
            ret.put("msg", "Apply failure.");
            return ret;
        }
    }

    @GetMapping("/hpList")
    public List<HealthcareJobApplication> getHPList(){
        return hpService.selectAllHPs();
    }

    @GetMapping("/hpByJobId/{jobAdvertisementId}")
    public List<HealthcareJobApplication> getHPByJobId(@PathVariable("jobAdvertisementId") Long jobAdvertisementId){
        return hpService.selectHPByJobId(jobAdvertisementId);
    }

    @GetMapping("/viewEntries")
    public List<ServiceEntries> selectEntries (@Param("userId")Long userId){
        return hpService.selectEntries(userId);
    }

    @GetMapping("/updateHour")
    public Map<String,String> updateHour(@Param("startTime") Timestamp startTime, @Param("endTime")Timestamp endTime, @Param("serviceEntryId")Long serviceEntryId){
        Map<String, String> ret = new HashMap<>();
        hpService.updateHour(startTime, endTime, serviceEntryId);
        ret.put("code", "200");
        ret.put("msg", "Update hour success.");
        return ret;
    }
}
