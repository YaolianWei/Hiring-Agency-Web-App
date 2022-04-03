package com.example.hiringagency.DAO;

import com.example.hiringagency.domain.entity.*;
import com.example.hiringagency.domain.model.BillingAccountInfo;
import com.example.hiringagency.domain.model.HPDetails;
import com.example.hiringagency.domain.model.Info;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
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

    List<HPDetails> selectAllHP();

    void addCTAccount(String firstName, String lastName, String username, String password, String postalAddress, Long phoneNumber, String email);

    Info selectCTInfoById(@Param("careTakerRegistrationId") Long careTakerRegistrationId);

    void updateCTId(@Param("userId") Long userId, @Param("careTakerRegistrationId") Long careTakerRegistrationId);

    List<Users> selectAllCT();

    List<HealthcareJobApplication> selectHPbyRequest(@Param("serviceType") Long serviceType, @Param("genderSpecific") Long genderSpecific);

    List<HealthcareJobApplication> selectHPbyType(@Param("serviceType") Long serviceType);

    List<CareRequests> selectAllRequests();

    List<ServiceEntries> selectServiceEntries(@Param("careRequestId") Long careRequestId);

    CareRequests selectRequestById(@Param("careRequestId") Long careRequestId);

    ServiceEntries selectEntriesById(@Param("serviceEntryId") Long serviceEntryId);

    List<ServiceEntries> selectEntriesByHp(@Param("userId") Long userId);

    List<Billing> selectBillingByRequest(@Param("careRequestId") Long careRequestId);

    void assignHP(@Param("userId") Long userId, @Param("serviceEntryId") Long serviceEntryId);

    void deAssignHP(@Param("serviceEntryId") Long serviceEntryId);

    Long selectMaxServiceId();

    void addBilling(Billing billing);

    List<BillingAccountInfo> selectBilling();

    void pay(@Param("sum") double sum, @Param("billingId") Long billingId);

    double selectPaidById(@Param("billingId") Long billingId);

    Boolean softDeleteUser(@Param("userId") Long userId);

    void withdraw(@Param("serviceEntryId") long serviceEntryId);

    List<CareRequests> selectRequestByCt(@Param("careTakerId") Long careTakerId);

    void updateHour(@RequestBody ServiceEntries serviceEntries);

    void terminate(@Param("careRequestId") Long careRequestId);

    HPAccount selectHPAccountById(@Param("userId")Long userId);

    void addCTPayment(@Param("amount") double amount, @Param("date") Date date, @Param("billingId") Long billingId);

    void payHP(@Param("sum") double sum, @Param("hpId") Long hpId);

    void addHPPayment(@Param("amount") double amount, @Param("date") Date date, @Param("hpAccountId") Long hpAccountId);

    List<CareRequests> selectWithdrawRequests();

    List<CareRequests> selectTerminateRequests();

    List<HPAccount> selectHPAccount();
}