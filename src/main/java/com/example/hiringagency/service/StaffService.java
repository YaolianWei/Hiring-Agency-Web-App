package com.example.hiringagency.service;

import com.example.hiringagency.domain.entity.*;
import com.example.hiringagency.domain.model.Info;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface StaffService {
    void setAd(JobAdvertisements jobAdvertisements);

    List<JobAdvertisements> viewAllAds();

    void deleteAd(@Param("jobAdvertisementId") long AdvertisementId);

    void addHPAccount(String firstName, String lastName, String username, String password, String postalAddress, Long phoneNumber, String email);

    // hire HP - 1
    Info selectHPInfoById(@Param("healthcareJobApplicationId") Long healthcareJobApplicationId);

    // hire HP - 2
    Long maxId();

    // hire HP - 3
    void updateHPId(@Param("userId") Long userId, @Param("healthcareJobApplicationId") Long healthcareJobApplicationId);

    List<Users> allHP();

    void addCTAccount(String firstName, String lastName, String username, String password, String postalAddress, Long phoneNumber, String email);

    Info selectCTInfoById(@Param("careTakerRegistrationId") Long careTakerRegistrationId);

    void updateCTId(@Param("userId") Long userId, @Param("careTakerRegistration") Long careTakerRegistration);

    List<Users> allCT();

    List<Users> selectHPbyRequest(@Param("careRequestId") Long careRequestId);

    void addService(CareService careService);

    void terminateService(@Param("serviceId") Long serviceId);

    void reAssignHP(@Param("serviceId") Long serviceId, @Param("hpid") Long hpid);

    void addBilling(Billing billing);

    List<CareRequests> selectRequests();

    List<CareService> selectPendingService();

    List<CareService> selectTerminateService();

    List<Billing> selectBilling();

    Boolean softDeleteCT(@Param("careTakerId") Long careTakerId);
}
