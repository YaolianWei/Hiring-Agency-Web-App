package com.example.hiringagency.DAO;

import com.example.hiringagency.domain.entity.*;
import com.example.hiringagency.domain.model.ScheduleDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
@Repository
public interface HPMapper {

    void setHP(HealthcareJobApplication healthcareJobApplication);

    List<HealthcareJobApplication> selectAllHPs();

    List<HealthcareJobApplication> selectHPByJobId(@Param("jobAdvertisementId")Long jobAdvertisementId);

    List<HealthcareJobApplication> selectAllSsn();

    List<ScheduleDetails> selectEntries(@Param("userId")Long userId);

    void updateHour(@RequestBody ServiceEntries serviceEntries);

    ServiceEntries selectRequestByEntry(@Param("serviceEntryId")Long serviceEntryId);

    Billing selectBillingByRequest(@Param("careRequestId")Long careRequestId);

    void updateCost(@Param("billingId")Long billingId, @Param("sum")double sum);

    double selectCostById(@Param("billingId")Long billingId);

    Users selectHPById(@Param("userId")Long userId);

    HPAccount selectHPAccountById(@Param("userId")Long userId);

    void updateSalary(@Param("userId")Long userId, @Param("salary")double salary);

    List<HPPayment> selectHPPaymentById(@Param("hpAccountId")Long hpAccountId);

    void terminate(@Param("careRequestId") Long careRequestId);

    List<ServiceEntries> selectServiceEntries(@Param("careRequestId") Long careRequestId);
}