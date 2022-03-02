package com.example.hiringagency.DAO;

import com.example.hiringagency.domain.entity.*;
import com.example.hiringagency.domain.model.Info;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StaffMapper {
    void setAd(JobAdvertisements jobAdvertisements);

    List<JobAdvertisements> selectAllAds();

    void deleteAd(@Param("jobAdvertisementId") long jobAdvertisementId);

    void addHPAccount(String firstName, String lastName, String username, String password, String postalAddress, Long phoneNumber, String email);

    // hire HP - 1
    Info selectHPInfoById(@Param("healthcareJobApplicationId") Long healthcareJobApplicationId);

    // hire HP - 2
    Long selectMaxId();

    // hire HP - 3
    void updateHPId(@Param("userId") Long userId, @Param("healthcareJobApplicationId") Long healthcareJobApplicationId);

    List<Users> selectAllHP();

    void addCTAccount(String firstName, String lastName, String username, String password, String postalAddress, Long phoneNumber, String email);

    Info selectCTInfoById(@Param("careTakerRegistrationId") Long careTakerRegistrationId);

    void updateCTId(@Param("userId") Long userId, @Param("careTakerRegistrationId") Long careTakerRegistrationId);

    List<Users> selectAllCT();

    List<Users> selectHPbyRequest(@Param("careRequestId") Long careRequestId);

    void addService(CareService careService);

    void terminateService(@Param("serviceId") Long serviceId);

    void reAssignHP(@Param("serviceId") Long serviceId, @Param("hpid") Long hpid);

    void addBilling(Billing billing);

    List<CareRequests> selectAllRequests();

    List<CareService> selectPendingService();

    Long selectPendingServiceById(@Param("careTakerId") Long careTakerId);

    Boolean softDeleteCT(@Param("careTakerId") Long careTakerId);

    List<CareService> selectTerminateService();

    List<Billing> selectBilling();
}