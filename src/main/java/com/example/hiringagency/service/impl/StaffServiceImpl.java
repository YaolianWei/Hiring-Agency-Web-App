package com.example.hiringagency.service.impl;

import com.example.hiringagency.DAO.StaffMapper;
import com.example.hiringagency.domain.entity.JobAdvertisements;
import com.example.hiringagency.domain.entity.Users;
import com.example.hiringagency.domain.model.HPInfo;
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
    public void deleteAd(@Param("jobAdvertisementID") long jobAdvertisementID) {
        staffMapper.deleteAd(jobAdvertisementID);
    }

    // hire HP - 一
    @Override
    public void addHPAccount(String firstName, String lastName, String username, String password, String postalAddress, Long phoneNumber, String email) {
        staffMapper.addHPAccount(firstName, lastName, username, password, postalAddress, phoneNumber, email);
    }

    // hire HP - 1
    @Override
    public HPInfo selectInfoById(@Param("healthcareJobApplicationId") Long healthcareJobApplicationId){
        return staffMapper.selectInfoById(healthcareJobApplicationId);
    }

    // hire HP - 2
    @Override
    public Long maxId(){
        return staffMapper.selectMaxId();
    }

    // hire HP - 3
    @Override
    public void updateUserId(@Param("userId") Long userId, @Param("healthcareJobApplicationId") Long healthcareJobApplicationId){
        staffMapper.updateUserId(userId, healthcareJobApplicationId);
    }

    @Override
    public List<Users> allHP(){
        return staffMapper.selectAllHP();
    }

}
