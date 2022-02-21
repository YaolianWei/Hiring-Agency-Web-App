package com.example.hiringagency.controller;

import com.example.hiringagency.domain.entity.HealthcareJobApplication;
import com.example.hiringagency.service.HPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HPController {

    @Autowired
    private HPService hpService;

    @GetMapping("/addHP")
    public Map<String,String> addHP(HealthcareJobApplication healthcareJobApplication){
        Map<String, String> ret = new HashMap<String, String>();
        hpService.setHP(healthcareJobApplication);

        ret.put("code", "200");
        ret.put("msg", "Set advertisement success.");
        return ret;
    }

    @GetMapping("/hpList")
    public List<HealthcareJobApplication> getHPList(){
        return hpService.selectAllHPs();
    }
}
