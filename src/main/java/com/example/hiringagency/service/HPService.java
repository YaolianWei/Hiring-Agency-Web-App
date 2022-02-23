package com.example.hiringagency.service;

import com.example.hiringagency.domain.entity.HealthcareJobApplication;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HPService {
    void setHP(HealthcareJobApplication healthcareJobApplication);

    List<HealthcareJobApplication> selectAllHPs();

    List<HealthcareJobApplication> selectHPByJobId(@Param("jobAdvertisementId")Long jobAdvertisementId);

}
