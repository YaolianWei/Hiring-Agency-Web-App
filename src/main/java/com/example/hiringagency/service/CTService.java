package com.example.hiringagency.service;

import com.example.hiringagency.domain.entity.Billing;
import com.example.hiringagency.domain.entity.CareRequests;
import com.example.hiringagency.domain.entity.CareTakerRegistration;
import com.example.hiringagency.domain.entity.CareService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CTService {

    void CTRegister(CareTakerRegistration careTakerRegistration);

    List<CareTakerRegistration> selectAllCTs();

    void addRequest(CareRequests careRequests);

    List<CareRequests> selectRequests(@Param("careTakerId") Long careTakerId);

    List<CareService> selectPendingService(@Param("careTakerId") Long careTakerId);

    List<CareService> selectTerminateService(@Param("careTakerId") Long careTakerId);

    List<Billing> selectBilling(@Param("careTakerId") Long careTakerId);
}
