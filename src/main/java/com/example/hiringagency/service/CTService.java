package com.example.hiringagency.service;

import com.example.hiringagency.domain.entity.Billing;
import com.example.hiringagency.domain.entity.CareRequests;
import com.example.hiringagency.domain.entity.CareTakerRegistration;
import com.example.hiringagency.domain.entity.ServiceEntries;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CTService {

    void CTRegister(CareTakerRegistration careTakerRegistration);

    List<CareTakerRegistration> selectAllCTs();

    boolean addRequest(CareRequests careRequests);

    List<CareRequests> selectRequests(@Param("careTakerId") Long careTakerId);

    List<ServiceEntries> selectServiceEntries(@Param("careRequestId") Long careRequestId);

    void addEntries(Long careRequestId);

    List<Billing> selectBilling(@Param("careTakerId") Long careTakerId);

    void pay(@Param("amount") double amount, @Param("billingId") Long billingId);
}
