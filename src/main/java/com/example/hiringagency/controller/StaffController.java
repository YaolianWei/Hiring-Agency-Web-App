package com.example.hiringagency.controller;

import com.example.hiringagency.domain.entity.*;
import com.example.hiringagency.domain.model.Info;
import com.example.hiringagency.service.StaffService;
import com.example.hiringagency.service.Utilities;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    // add new advertisement
    @GetMapping("/setAd")
    @ResponseBody
    public Map<String,String> setAd(JobAdvertisements jobAdvertisements){
        Map<String, String> ret = new HashMap<String, String>();
        staffService.setAd(jobAdvertisements);

        ret.put("code", "200");
        ret.put("msg", "Set advertisement success.");
        return ret;
    }

    // get current advertisement list
    @GetMapping("/adList")
    public List<JobAdvertisements> getAdList(){
        return staffService.viewAllAds();
    }

    // delete advertisement
    @GetMapping("/deleteAd")
    public Map<String, String> deleteAd(@Param("jobAdvertisementId") long jobAdvertisementId){
        Map<String, String> ret = new HashMap<String, String>();
        staffService.deleteAd(jobAdvertisementId);
        ret.put("code", "200");
        ret.put("msg", "Delete advertisement success.");
        return ret;
    }

    // hire a healthcare professional
    @GetMapping("/hireHP")
    public Map<String,String> hireHP(@Param("healthcareJobApplicationId") Long healthcareJobApplicationId){
        Map<String, String> ret = new HashMap<String, String>();
        Info info = staffService.selectHPInfoById(healthcareJobApplicationId);

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
        staffService.updateHPId(userId,healthcareJobApplicationId);
        ret.put("code", "200");
        ret.put("msg", "Hire the healthcare professional success.");
        return ret;
    }

    // list all hired healthcare professional
    @GetMapping("/allHP")
    public List<Users> allHP(){
        return staffService.allHP();
    }

    // approve care taker's registration
    @GetMapping("/approveCT")
    public Map<String,String> approveCT(@Param("careTakerRegistrationId") Long careTakerRegistrationId){
        Map<String, String> ret = new HashMap<String, String>();
        Info info = staffService.selectCTInfoById(careTakerRegistrationId);

        String username = null;
        Long no = staffService.maxId();
        if(no < 10){
            username = info.getLastName() + '0' + no;
        }
        else username = info.getLastName() + no;

        String Password = utilities.randomPassword();
        utilities.sendEmail(username,info.getEmail(),Password);

        String pwd = utilities.getSalt(Password);

        staffService.addCTAccount(info.getFirstName(),info.getLastName(),username,pwd, info.getPostalAddress(), info.getPhoneNumber(), info.getEmail());

        Long userId = no + 1;
        staffService.updateCTId(userId,careTakerRegistrationId);
        ret.put("code", "200");
        ret.put("msg", "Approve the care taker registration success.");
        return ret;
    }

    // list all approved care taker
    @GetMapping("/allCT")
    public List<Users> allCT(){
        return staffService.allCT();
    }

    @GetMapping("/selectHPbyRequest")
    public List<Users> selectHPbyRequest(@Param("careRequestId") Long careRequestId){
        return staffService.selectHPbyRequest(careRequestId);
    }

    @PostMapping("/addService")
    public Map<String,String> addService(CareService careService){
        Map<String, String> ret = new HashMap<String, String>();
        staffService.addService(careService);
        ret.put("code", "200");
        ret.put("msg", "Add service success.");
        return ret;
    }

    @PostMapping("/addBilling")
    public Map<String,String> addBilling(Billing billing){
        Map<String, String> ret = new HashMap<String, String>();
        staffService.addBilling(billing);
        ret.put("code", "200");
        ret.put("msg", "Add billing success.");
        return ret;
    }

    @GetMapping("/terminateService")
    public Map<String, String> terminateService(@Param("serviceId") long serviceId){
        Map<String, String> ret = new HashMap<String, String>();
        staffService.terminateService(serviceId);
        ret.put("code", "200");
        ret.put("msg", "Terminate service success.");
        return ret;
    }

    @GetMapping("/reAssignHP")
    public Map<String, String> reAssignHP(@Param("serviceId") long serviceId, @Param("hpid") Long hpid){
        Map<String, String> ret = new HashMap<String, String>();
        staffService.reAssignHP(serviceId, hpid);
        ret.put("code", "200");
        ret.put("msg", "Re-assign HP success.");
        return ret;
    }

    // all requests list
    @GetMapping("/allRequests")
    public List<CareRequests> allRequests(){
        return staffService.requestsList();
    }

    @GetMapping("/selectPendingService")
    public List<CareService> selectPendingService(){
        return staffService.selectPendingService();
    }

    @GetMapping("/selectTerminateService")
    public List<CareService> selectTerminateService(){
        return staffService.selectTerminateService();
    }

    @GetMapping("/selectBilling")
    public List<Billing> selectBilling(){
        return staffService.selectBilling();
    }

    // soft delete care taker
    @GetMapping("/softDeleteCT")
    public Map<String, String> softDeleteCT(@Param("careTakerId") Long careTakerId){
        Map<String, String> ret = new HashMap<String, String>();
        if (staffService.softDeleteCT(careTakerId)){
            ret.put("code", "200");
            ret.put("msg", "Delete care taker success.");
        }else {
            ret.put("code", "400");
            ret.put("msg", "The care taker has pending service now.");
        }
        return ret;
    }
}
