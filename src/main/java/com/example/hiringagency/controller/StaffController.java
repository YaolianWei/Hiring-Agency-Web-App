package com.example.hiringagency.controller;

import com.example.hiringagency.domain.entity.*;
import com.example.hiringagency.domain.model.BillingAccountInfo;
import com.example.hiringagency.domain.model.HPAccountInfo;
import com.example.hiringagency.domain.model.HPDetails;
import com.example.hiringagency.domain.model.Info;
import com.example.hiringagency.service.StaffService;
import com.example.hiringagency.service.Utilities;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        Map<String, String> ret = new HashMap<>();
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
        Map<String, String> ret = new HashMap<>();
        staffService.deleteAd(jobAdvertisementId);
        ret.put("code", "200");
        ret.put("msg", "Delete advertisement success.");
        return ret;
    }

    // hire a healthcare professional
    @GetMapping("/hireHP")
    public Map<String,String> hireHP(@Param("healthcareJobApplicationId") Long healthcareJobApplicationId, Double hourlyRate){
        Map<String, String> ret = new HashMap<>();
        Info info = staffService.selectHPInfoById(healthcareJobApplicationId);

        String username;
        Long no = staffService.maxId();
        if(no < 10){
            username = info.getLastName() + '0' + no;
        }
        else username = info.getLastName() + no;

        String Password = utilities.randomPassword();
        utilities.sendEmail(username,info.getEmail(),Password);

        String pwd = utilities.getSalt(Password);

        staffService.addHPAccount(info.getFirstName(),info.getLastName(),username,pwd, info.getPostalAddress(), info.getPhoneNumber(), info.getEmail(), hourlyRate);

        Long userId = no + 1;
        staffService.updateHPId(userId,healthcareJobApplicationId);
        ret.put("code", "200");
        ret.put("msg", "Hire the healthcare professional success.");
        return ret;
    }

    // list all hired healthcare professional
    @GetMapping("/allHP")
    public List<HPDetails> allHP(){
        return staffService.allHP();
    }

    // approve care taker's registration
    @GetMapping("/approveCT")
    public Map<String,String> approveCT(@Param("careTakerRegistrationId") Long careTakerRegistrationId){
        Map<String, String> ret = new HashMap<>();
        Info info = staffService.selectCTInfoById(careTakerRegistrationId);

        String username;
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

    // all requests list
    @GetMapping("/allRequests")
    public List<CareRequests> allRequests(){
        return staffService.requestsList();
    }

    // get each service request entries
    @GetMapping("/getEntriesList")
    public List<ServiceEntries> getEntriesList(Long careRequestId){
        return staffService.selectServiceEntries(careRequestId);
    }

    // check the request has billing account
    @GetMapping("/hasAddBilling")
    public boolean selectBillingByRequest(@Param("careRequestId") Long careRequestId){
        //true是有账户
        return staffService.selectBillingByRequest(careRequestId);
    }

    // get optional hp list
    @GetMapping("/assignHPList")
    public List<HealthcareJobApplication> assignHPList(@Param("careRequestId") Long careRequestId, @Param("serviceEntryId") Long serviceEntryId){
        return staffService.assignHPList(careRequestId, serviceEntryId);
    }

    // assign healthcare professional
    @GetMapping("/assignHP")
    public Map<String, String> assignHP(@Param("userId") Long userId, @Param("serviceEntryId") Long serviceEntryId){
        Map<String, String> ret = new HashMap<>();
        staffService.assignHP(userId, serviceEntryId);
        ret.put("code", "200");
        ret.put("msg", "Assign HP success.");
        return ret;
    }

    @GetMapping("/selectEntriesByHp")
    public List<ServiceEntries> selectEntriesByHp(@Param("userId") Long userId){
        return staffService.selectEntriesByHp(userId);
    }

    // staff deAssign healthcare worker
    @GetMapping("/deAssignHP")
    public Map<String, String> deAssignHP(@Param("serviceEntryId") Long serviceEntryId){
        Map<String, String> ret = new HashMap<>();
        staffService.deAssignHP(serviceEntryId);
        ret.put("code", "200");
        ret.put("msg", "UnAssign HP success.");
        return ret;
    }

    // add billing account
    @PostMapping("/addBilling")
    public Map<String,String> addBilling(@RequestBody Billing billing){
        Map<String, String> ret = new HashMap<>();
        staffService.addBilling(billing);
        ret.put("code", "200");
        ret.put("msg", "Add billing success.");
        return ret;
    }

    // staff can see all billing account info
    @GetMapping("/allBillingInfoList")
    public List<BillingAccountInfo> billingInfoList(){
        return staffService.selectBilling();
    }

    // staff pay for the service by billingId
    @GetMapping("/payBilling")
    public Map<String, String> pay(@Param("amount") double amount, @Param("billingId") Long billingId){
        Map<String, String> ret = new HashMap<>();
        boolean canPay = staffService.pay(amount, billingId);
        if(canPay){
            ret.put("code", "200");
            ret.put("msg", "Pay billing account success.");
        } else {
            ret.put("code", "201");
            ret.put("msg", "Pay billing account failure.");
        }
        return ret;
    }

    // staff soft delete care taker
    @GetMapping("/softDeleteCT")
    public Map<String, String> softDeleteCT(@Param("careTakerId") Long careTakerId){
        Map<String, String> ret = new HashMap<>();
        if (staffService.softDeleteCT(careTakerId)){
            ret.put("code", "200");
            ret.put("msg", "Delete care taker success.");
        }else {
            ret.put("code", "201");
            ret.put("msg", "There are patients associated with the care taker now.");
        }
        return ret;
    }

    // staff terminate the service
    @GetMapping("/terminate")
    public Map<String, String> withdraw(@Param("careRequestId") long careRequestId){
        Map<String, String> ret = new HashMap<>();
        staffService.withdraw(careRequestId);
        ret.put("code", "200");
        ret.put("msg", "Withdraw request success.");
        return ret;
    }

    @GetMapping("/viewRequestByCt")
    public List<CareRequests> selectRequestByCt(@Param("careTakerId") Long careTakerId){
        return staffService.selectRequestByCt(careTakerId);
    }

    // staff add service hour for healthcare worker
    @PostMapping("/addHour")
    public Map<String, String> updateHour(@RequestBody ServiceEntries serviceEntries){
        Map<String, String> ret = new HashMap<>();
        staffService.updateHour(serviceEntries);
        ret.put("code", "200");
        ret.put("msg", "Add hour success.");
        return ret;
    }

    // staff soft delete healthcare professional
    @GetMapping("/softDeleteHP")
    public Map<String, String> softDeleteHP(@Param("hpId") Long hpId){
        Map<String, String> ret = new HashMap<>();
        if (staffService.softDeleteHP(hpId)){
            ret.put("code", "200");
            ret.put("msg", "Delete healthcare professional success.");
        }else {
            ret.put("code", "201");
            ret.put("msg", "Pay off before delete this healthcare professional.");
        }
        return ret;
    }

    // staff pay foe the HP
    @GetMapping("/payHP")
    public Map<String, String> payHP(@Param("amount") double amount, @Param("hpId") Long hpId){
        Map<String, String> ret = new HashMap<>();
        boolean canPay = staffService.payHP(amount, hpId);
        if(canPay){
            ret.put("code", "200");
            ret.put("msg", "Pay HP account success.");
        } else {
            ret.put("code", "201");
            ret.put("msg", "Pay HP account failure.");
        }
        return ret;
    }

    // staff view the hp payment account
    @GetMapping("/viewHPAccount")
    public List<HPAccountInfo> selectHPAccount(){
        return staffService.selectHPAccount();
    }

    // staff view the care taker withdrawing service list
    @GetMapping("/withdrawRequests")
    public List<CareRequests> selectWithdrawRequests(){
        return staffService.selectWithdrawRequests();
    }

    // staff view terminate service
    @GetMapping("/terminateRequests")
    public List<CareRequests> selectTerminateRequests(){
        return staffService.selectTerminateRequests();
    }
}