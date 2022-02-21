package com.example.hiringagency.service;

import com.example.hiringagency.domain.entity.HealthcareJobApplication;

import java.util.List;

public interface HPService {
    void setHP(HealthcareJobApplication healthcareJobApplication);

    List<HealthcareJobApplication> selectAllHPs();

}
