package com.example.hiringagency.DAO;

import com.example.hiringagency.domain.entity.CareRequests;
import com.example.hiringagency.domain.entity.CareTakerRegistration;
import com.example.hiringagency.domain.entity.ServiceEntries;
import com.example.hiringagency.domain.model.BillingAccountInfo;
import com.example.hiringagency.domain.model.BillingDetails;
import com.example.hiringagency.domain.model.EntriesDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface CTMapper {

    void CTRegister(CareTakerRegistration careTakerRegistration);

    List<CareTakerRegistration> selectAllCTs();

    void addRequest(CareRequests careRequests);

    List<CareRequests> selectRequests(@Param("careTakerId") Long careTakerId);

    CareRequests selectRequestsById(@Param("careRequestId") Long careRequestId);

    List<ServiceEntries> selectServiceEntries(@Param("careRequestId") Long careRequestId);

    List<EntriesDetails> selectEntriesDetails(@Param("careRequestId") Long careRequestId);

    void addEntries(ServiceEntries serviceEntries);

    List<BillingAccountInfo> selectBilling(@Param("careTakerId") Long careTakerId);

    void pay(@Param("amount") double amount, @Param("billingId") Long billingId);

    Long selectMaxId();

    List<BillingDetails> selectCompleteEntriesByRequest(@Param("careRequestId") Long careRequestId);

    Double selectRateByRequest(@Param("careRequestId") Long careRequestId);
}
