package com.example.hiringagency.service.impl;

import com.example.hiringagency.DAO.StaffMapper;
import com.example.hiringagency.DAO.UserMapper;
import com.example.hiringagency.domain.entity.*;
import com.example.hiringagency.domain.model.Info;
import com.example.hiringagency.service.StaffService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffMapper staffMapper;

    @Override
    public void setAd(JobAdvertisements jobAdvertisements) {
        staffMapper.setAd(jobAdvertisements);
    }

    public List<JobAdvertisements> viewAllAds(){
        return staffMapper.selectAllAds();
    }

    @Override
    public void deleteAd(@Param("jobAdvertisementId") long jobAdvertisementId) {
        staffMapper.deleteAd(jobAdvertisementId);
    }

    // hire HP - 一
    @Override
    public void addHPAccount(String firstName, String lastName, String username, String password, String postalAddress, Long phoneNumber, String email) {
        staffMapper.addHPAccount(firstName, lastName, username, password, postalAddress, phoneNumber, email);
    }

    // hire HP - 1
    @Override
    public Info selectHPInfoById(@Param("healthcareJobApplicationId") Long healthcareJobApplicationId){
        return staffMapper.selectHPInfoById(healthcareJobApplicationId);
    }

    // hire HP - 2
    @Override
    public Long maxId(){
        return staffMapper.selectMaxId();
    }

    // hire HP - 3
    @Override
    public void updateHPId(@Param("userId") Long userId, @Param("healthcareJobApplicationId") Long healthcareJobApplicationId){
        staffMapper.updateHPId(userId, healthcareJobApplicationId);
    }

    @Override
    public List<Users> allHP(){
        return staffMapper.selectAllHP();
    }

    @Override
    public void addCTAccount(String firstName, String lastName, String username, String password, String postalAddress, Long phoneNumber, String email) {
        staffMapper.addCTAccount(firstName, lastName, username, password, postalAddress, phoneNumber, email);
    }

    @Override
    public Info selectCTInfoById(@Param("careTakerRegistrationId") Long careTakerRegistrationId){
        return staffMapper.selectCTInfoById(careTakerRegistrationId);
    }

    @Override
    public void updateCTId(@Param("userId") Long userId, @Param("careTakerRegistration") Long careTakerRegistration){
        staffMapper.updateCTId(userId, careTakerRegistration);
    }

    @Override
    public List<Users> allCT(){
        return staffMapper.selectAllCT();
    }

    @Override
    public List<Users> selectHPbyRequest(@Param("careRequestId") Long careRequestId){
        return staffMapper.selectHPbyRequest(careRequestId);
    }

    @Override
    public void addService(CareService careService){
        staffMapper.addService(careService);
    }

    @Override
    public void terminateService(@Param("serviceId") Long serviceId){
        staffMapper.terminateService(serviceId);
    }

    @Override
    public void reAssignHP(@Param("serviceId") Long serviceId, @Param("hpid") Long hpid){
        staffMapper.reAssignHP(serviceId, hpid);
    }

    @Override
    public void addBilling(Billing billing){
        staffMapper.addBilling(billing);
    }

    @Override
    public List<CareRequests> selectRequests(){
        return staffMapper.selectRequests();
    }

    @Override
    public List<CareService> selectPendingService(){
        return staffMapper.selectPendingService();
    }

    @Override
    public List<CareService> selectTerminateService(){
        return staffMapper.selectTerminateService();
    }

    @Override
    public List<Billing> selectBilling(){
        return staffMapper.selectBilling();
    }

    @Override
    public Boolean softDeleteCT(@Param("careTakerID") Long careTakerId){
        if (staffMapper.selectPendingServiceById(careTakerId) == null){
            staffMapper.softDeleteCT(careTakerId);
            return true;
        } else {
            return false;
        }
    }
}
