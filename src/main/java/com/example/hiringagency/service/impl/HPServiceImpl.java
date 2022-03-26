package com.example.hiringagency.service.impl;

import com.example.hiringagency.DAO.HPMapper;
import com.example.hiringagency.domain.entity.Billing;
import com.example.hiringagency.domain.entity.HealthcareJobApplication;
import com.example.hiringagency.domain.entity.ServiceEntries;
import com.example.hiringagency.domain.model.ScheduleDetails;
import com.example.hiringagency.service.HPService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.sql.Timestamp;
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
        hpMapper.updateCost(b.getBillingId(), sum);
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
}
