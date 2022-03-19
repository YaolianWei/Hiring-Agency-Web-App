package com.example.hiringagency.service;

import com.example.hiringagency.domain.entity.HealthcareJobApplication;
import com.example.hiringagency.domain.entity.ServiceEntries;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

public interface HPService {
    boolean setHP(HealthcareJobApplication healthcareJobApplication);

    List<HealthcareJobApplication> selectAllHPs();

    List<HealthcareJobApplication> selectHPByJobId(@Param("jobAdvertisementId")Long jobAdvertisementId);

    List<ServiceEntries> selectEntries (@Param("userId")Long userId);

    void updateHour(@Param("startTime") Timestamp startTime, @Param("endTime")Timestamp endTime, @Param("serviceEntryId")Long serviceEntryId);
}
