package com.example.hiringagency.service.impl;

import com.example.hiringagency.DAO.HPMapper;
import com.example.hiringagency.domain.entity.HealthcareJobApplication;
import com.example.hiringagency.service.HPService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HPServiceImpl implements HPService {
    @Autowired
    private HPMapper hpMapper;

    public void setHP(HealthcareJobApplication healthcareJobApplication) {
        hpMapper.setHP(healthcareJobApplication);
    }

    public List<HealthcareJobApplication> selectAllHPs(){
        return hpMapper.selectAllHPs();
    }

    public List<HealthcareJobApplication> selectHPByJobId(@Param("jobAdvertisementId")Long jobAdvertisementId){
        return hpMapper.selectHPByJobId(jobAdvertisementId);
    }
}
