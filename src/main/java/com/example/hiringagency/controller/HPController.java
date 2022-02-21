package com.example.hiringagency.controller;

import com.example.hiringagency.domain.entity.HealthcareJobApplication;
import com.example.hiringagency.service.HPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HPController {

    @Autowired
    private HPService hpService;

    @PostMapping("/addHP")
    public Map<String,String> addHP(@RequestBody HealthcareJobApplication healthcareJobApplication){
        Map<String, String> ret = new HashMap<String, String>();
        hpService.setHP(healthcareJobApplication);

        ret.put("code", "200");
        ret.put("msg", "Apply success.");
        return ret;
    }

    @GetMapping("/hpList")
    public List<HealthcareJobApplication> getHPList(){
        return hpService.selectAllHPs();
    }
}
