package com.example.hiringagency.service.impl;

import com.example.hiringagency.DAO.HPMapper;
import com.example.hiringagency.domain.entity.*;
import com.example.hiringagency.domain.model.HPAccountInfo;
import com.example.hiringagency.domain.model.ScheduleDetails;
import com.example.hiringagency.service.HPService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.List;

@Service
public class HPServiceImpl implements HPService {
    @Autowired
    private HPMapper hpMapper;

    @Override
    public boolean setHP(HealthcareJobApplication healthcareJobApplication) {
        boolean canSet = true;
        String ssn = healthcareJobApplication.getSsn();
        List<HealthcareJobApplication> list = hpMapper.selectAllSsn();
        for (HealthcareJobApplication hja : list) {
            if (hja.getSsn().equals(ssn)) {
                canSet = false;
                break;
            }
        }
        if (canSet){
            hpMapper.setHP(healthcareJobApplication);
        }
        return canSet;
    }

    @Override
    public List<HealthcareJobApplication> selectAllHPs(){
        return hpMapper.selectAllHPs();
    }

    @Override
    public List<HealthcareJobApplication> selectHPByJobId(@Param("jobAdvertisementId")Long jobAdvertisementId){
        return hpMapper.selectHPByJobId(jobAdvertisementId);
    }

    @Override
    public List<ScheduleDetails> selectEntries (@Param("userId")Long userId){
        return hpMapper.selectEntries(userId);
    }

    @Override
    public void updateHour(@RequestBody ServiceEntries serviceEntries){
        hpMapper.updateHour(serviceEntries);

        long time1 = serviceEntries.getStartTime().getTime();
        long time2 = serviceEntries.getEndTime().getTime();
        double hours = (double) ((time2 - time1) / (1000*60*60));
        double minutes = (double) (((time2 - time1) / 1000 - hours*(60*60)) / 60);
        double hour = sum(hours, minutes/60);

        ServiceEntries se = hpMapper.selectRequestByEntry(serviceEntries.getServiceEntryId());
        Billing b = hpMapper.selectBillingByRequest(se.getCareRequestId());
        double cost = mul(hour, b.getHourlyRate());
        double amountYetToPay = hpMapper.selectCostById(b.getBillingId());
        double sum = sum(cost, amountYetToPay);
        sum = (double) Math.round(sum * 100) / 100;
        hpMapper.updateCost(b.getBillingId(), sum);

        Users hp = hpMapper.selectHPById(se.getHpId());
        double salary = mul(hour, hp.getHourlyRate());
        HPAccountInfo hpa = hpMapper.selectHPAccountById(se.getHpId());
        salary = sum(salary, hpa.getAmountYetToPay());
        salary = (double) Math.round(salary * 100) / 100;
        hpMapper.updateSalary(se.getHpId(), salary);

        List<ServiceEntries> seList = hpMapper.selectServiceEntries(se.getCareRequestId());
        boolean canUpdate = true;
        for (ServiceEntries ses : seList){
            if (ses.getStatus() == 1) {
                canUpdate = false;
                break;
            }
        }
        if (canUpdate){
            hpMapper.terminate(se.getCareRequestId());
        }
    }

    public double mul(double d1,double d2){
        BigDecimal bd1 = new BigDecimal(Double.toString(d1));
        BigDecimal bd2 = new BigDecimal(Double.toString(d2));
        return bd1.multiply(bd2).doubleValue();
    }

    public double sum(double d1,double d2){
        BigDecimal bd1 = new BigDecimal(Double.toString(d1));
        BigDecimal bd2 = new BigDecimal(Double.toString(d2));
        return bd1.add(bd2).doubleValue();
    }

    @Override
    public HPAccountInfo selectHPAccountById(@Param("userId")Long userId){
        return hpMapper.selectHPAccountById(userId);
    }

    @Override
    public List<HPPayment> selectHPPaymentById(@Param("hpAccountId")Long hpAccountId){
        return hpMapper.selectHPPaymentById(hpAccountId);
    }
}