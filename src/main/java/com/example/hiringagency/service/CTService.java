package com.example.hiringagency.service;

import com.example.hiringagency.domain.entity.CareRequests;
import com.example.hiringagency.domain.entity.CareTakerRegistration;
import com.example.hiringagency.domain.entity.ServiceEntries;
import com.example.hiringagency.domain.model.BillingAccountInfo;
import com.example.hiringagency.domain.model.BillingDetails;
import com.example.hiringagency.domain.model.EntriesDetails;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CTService {

    void CTRegister(CareTakerRegistration careTakerRegistration);

    List<CareTakerRegistration> selectAllCTs();

    boolean addRequest(CareRequests careRequests);

    List<CareRequests> selectRequests(@Param("careTakerId") Long careTakerId);

    List<EntriesDetails> entriesDetails(@Param("careRequestId") Long careRequestId);

    List<BillingAccountInfo> selectBilling(@Param("careTakerId") Long careTakerId);

    List<BillingDetails> selectCompleteEntriesByRequest(@Param("careRequestId") Long careRequestId);
}
