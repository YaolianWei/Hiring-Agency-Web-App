package com.example.hiringagency.DAO;

import com.example.hiringagency.domain.entity.Billing;
import com.example.hiringagency.domain.entity.CareRequests;
import com.example.hiringagency.domain.entity.CareTakerRegistration;
import com.example.hiringagency.domain.entity.ServiceEntries;
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

    void addEntries(ServiceEntries serviceEntries);

    List<Billing> selectBilling(@Param("careTakerId") Long careTakerId);

    void pay(@Param("amount") double amount, @Param("billingId") Long billingId);
}
