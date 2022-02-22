package com.example.hiringagency.controller;

import com.example.hiringagency.domain.entity.HealthcareJobApplication;
import com.example.hiringagency.service.HPService;
import com.example.hiringagency.service.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        Map<String, String> ret = new HashMap<String, String>();
        hpService.setHP(healthcareJobApplication);
        Boolean isCoNum = utilities.isCorrectNumFormat(Long.toString(healthcareJobApplication.getPhoneNumber()));
        if(!isCoNum){
            ret.put("code", "400");
            ret.put("msg", "Please enter phone number in the correct format.");
            return ret;
        }
        Boolean isCoEmail = utilities.isCorrectEmaFormat(healthcareJobApplication.getEmail());
        if(!isCoEmail){
            ret.put("code", "401");
            ret.put("msg", "Please enter email in the correct format.");
            return ret;
        }
        ret.put("code", "200");
        ret.put("msg", "Apply success.");
        return ret;
    }

    @GetMapping("/hpList")
    public List<HealthcareJobApplication> getHPList(){
        return hpService.selectAllHPs();
    }
}
