package com.example.hiringagency.service.impl;

import com.example.hiringagency.DAO.HPMapper;
import com.example.hiringagency.domain.entity.HealthcareJobApplication;
import com.example.hiringagency.domain.entity.ServiceEntries;
import com.example.hiringagency.service.HPService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class HPServiceImpl implements HPService {
    @Autowired
    private HPMapper hpMapper;

    @Override
    public boolean setHP(HealthcareJobApplication healthcareJobApplication) {
        boolean canSet = true;
        String ssn = healthcareJobApplication.getSsn();
        List<HealthcareJobApplication> list = hpMapper.selectAllSsn();
        for (HealthcareJobApplication hja : list) {
            if (hja.getSsn().equals(ssn)) {
                canSet = false;
                break;
            }
        }
        if (canSet){
            hpMapper.setHP(healthcareJobApplication);
        }
        return canSet;
    }

    @Override
    public List<HealthcareJobApplication> selectAllHPs(){
        return hpMapper.selectAllHPs();
    }

    @Override
    public List<HealthcareJobApplication> selectHPByJobId(@Param("jobAdvertisementId")Long jobAdvertisementId){
        return hpMapper.selectHPByJobId(jobAdvertisementId);
    }

    @Override
    public List<ServiceEntries> selectEntries (@Param("userId")Long userId){
        return hpMapper.selectEntries(userId);
    }

    @Override
    public void updateHour(@Param("startTime") Timestamp startTime, @Param("endTime")Timestamp endTime, @Param("serviceEntryId")Long serviceEntryId){
        hpMapper.updateHour(startTime, endTime, serviceEntryId);
    }
}
