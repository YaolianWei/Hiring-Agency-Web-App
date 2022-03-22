package com.example.hiringagency.DAO;

import com.example.hiringagency.domain.entity.*;
import com.example.hiringagency.domain.model.Info;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Mapper
@Repository
public interface StaffMapper {
    void setAd(JobAdvertisements jobAdvertisements);

    List<JobAdvertisements> selectAllAds();

    void deleteAd(@Param("jobAdvertisementId") long jobAdvertisementId);

    void addHPAccount(String firstName, String lastName, String username, String password, String postalAddress, Long phoneNumber, String email, Double hourlyRate);

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

    List<HealthcareJobApplication> selectHPbyRequest(@Param("serviceType") Long serviceType, @Param("genderSpecific") Long genderSpecific);

    List<CareRequests> selectAllRequests();

    List<ServiceEntries> selectServiceEntries(@Param("careRequestId") Long careRequestId);

    CareRequests selectRequestById(@Param("careRequestId") Long careRequestId);

    ServiceEntries selectEntriesById(@Param("serviceEntryId") Long serviceEntryId);

    List<ServiceEntries> selectEntriesByHp (@Param("userId") Long userId);

    void assignHP(@Param("userId") Long userId, @Param("serviceEntryId") Long serviceEntryId);

    void deAssignHP(@Param("serviceEntryId") Long serviceEntryId);

    void addBilling(Billing billing);

    List<Billing> selectBilling();

    void pay(@Param("amount") double amount, @Param("billingId") Long billingId);

    Boolean softDeleteCT(@Param("careTakerId") Long careTakerId);

    void withdraw(@Param("serviceEntryId") long serviceEntryId);

    List<CareRequests> selectRequestByCt(@Param("careTakerId") Long careTakerId);

    void updateHour(@Param("startTime") Timestamp startTime, @Param("endTime")Timestamp endTime, @Param("serviceEntryId")Long serviceEntryId);
}