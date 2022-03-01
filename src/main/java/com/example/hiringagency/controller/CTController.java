package com.example.hiringagency.controller;

import com.example.hiringagency.domain.entity.Billing;
import com.example.hiringagency.domain.entity.CareRequests;
import com.example.hiringagency.domain.entity.CareTakerRegistration;
import com.example.hiringagency.domain.entity.CareService;
import com.example.hiringagency.service.CTService;
import com.example.hiringagency.service.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CTController {

    @Autowired
    private CTService ctService;

    @Autowired
    private Utilities utilities;

    // register as a care taker
    @PostMapping("/CTRegister")
    public Map<String,String> CTRegister(@RequestBody CareTakerRegistration careTakerRegistration){
        Map<String, String> ret = new HashMap<String, String>();
        Boolean isCoNum = utilities.isCorrectNumFormat(Long.toString(careTakerRegistration.getPhoneNumber()));
        if(!isCoNum){
            ret.put("code", "400");
            ret.put("msg", "Please enter phone number in the correct format.");
            return ret;
        }
        Boolean isCoEmail = utilities.isCorrectEmaFormat(careTakerRegistration.getEmail());
        if(!isCoEmail){
            ret.put("code", "401");
            ret.put("msg", "Please enter email in the correct format.");
            return ret;
        }
        ctService.CTRegister(careTakerRegistration);
        ret.put("code", "200");
        ret.put("msg", "Register success.");
        return ret;
    }

    // care taker register list
    @GetMapping("/ctList")
    public List<CareTakerRegistration> getCTList(){
        return ctService.selectAllCTs();
    }

    // care taker request for a service
    @PostMapping("/addRequest")
    public Map<String,String> addRequest(@RequestBody CareRequests careRequests){
        Map<String, String> ret = new HashMap<String, String>();
        ctService.addRequest(careRequests);
        ret.put("code", "200");
        ret.put("msg", "Add request success.");
        return ret;
    }

    @GetMapping("/requestList")
    public List<CareRequests> getRequestList(Long careTakerId){
        return ctService.selectRequests(careTakerId);
    }

    @GetMapping("/pendingServiceList")
    public List<CareService> getPendingServiceList(Long careTakerId){
        return ctService.selectPendingService(careTakerId);
    }

    @GetMapping("/terminateServiceList")
    public List<CareService> getTerminateServiceList(Long careTakerId){
        return ctService.selectTerminateService(careTakerId);
    }

    @GetMapping("/billingList")
    public List<Billing> getBillingList(Long careTakerId){
        return ctService.selectBilling(careTakerId);
    }
}

