package com.example.hiringagency.service.impl;

import com.example.hiringagency.DAO.CTMapper;
import com.example.hiringagency.domain.entity.Billing;
import com.example.hiringagency.domain.entity.CareRequests;
import com.example.hiringagency.domain.entity.CareTakerRegistration;
import com.example.hiringagency.domain.entity.ServiceEntries;
import com.example.hiringagency.service.CTService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

@Service
public class CTServiceImpl implements CTService {

    @Autowired
    private CTMapper ctMapper;

    @Override
    public void CTRegister(CareTakerRegistration careTakerRegistration){
        ctMapper.CTRegister(careTakerRegistration);
    }

    @Override
    public List<CareTakerRegistration> selectAllCTs(){
        return ctMapper.selectAllCTs();
    }

    @Override
    public boolean addRequest(CareRequests careRequests){
        boolean canAdd = true;
        List<CareRequests> ctr = ctMapper.selectRequests(careRequests.getCareTakerId());
        for (CareRequests cr : ctr) {
            if ((cr.getFirstName().equals(careRequests.getFirstName())) && (cr.getLastName().equals(careRequests.getLastName())) && (cr.getServiceType().equals(careRequests.getServiceType()))) {
                List<ServiceEntries> ses = ctMapper.selectServiceEntries(cr.getCareRequestId());
                if (ses.size() != 0) {
                    List<Date> dates = CalDates(careRequests.getWeekDay(), Math.toIntExact(careRequests.getTotalDays()));
                    for (ServiceEntries se : ses) {
                        Date date = se.getDate();
                        if (dates.contains(date)) {
                            canAdd = false;
                            break;
                        }
                    }
                }
            }
        }
        if (canAdd){
            ctMapper.addRequest(careRequests);
        }
        return canAdd;
    }

    @Override
    public List<CareRequests> selectRequests(Long careTakerId){
        return ctMapper.selectRequests(careTakerId);
    }

    public List<Date> CalDates(String weekDays, int days) {
        String[] weekDay;
        String delimeter1 = ",";
        weekDay = weekDays.split(delimeter1);
        ArrayList<LocalDate> localDates = new ArrayList<>();
        int weeks  = days / weekDay.length + 1;
        for (String weekday : weekDay) {
            LocalDate date = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.of(Integer.parseInt(weekday))));
            localDates.add(date);
            for (int m = 1; m < weeks; m++) {
                Calendar cal = Calendar.getInstance();
                ZonedDateTime zonedDateTime = date.atStartOfDay(ZoneId.systemDefault());
                cal.setTime(Date.from(zonedDateTime.toInstant()));
                cal.add(Calendar.DATE, m * 7);
                localDates.add(cal.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            }
        }
        Collections.sort(localDates);
        ArrayList<Date> dates = new ArrayList<>();
        for (int n=0; n<days; n++){
            LocalDate date = localDates.get(n);
            ZoneId zoneId = ZoneId.systemDefault();
            ZonedDateTime zonedDateTime = date.atStartOfDay(zoneId);
            Date d = Date.from(zonedDateTime.toInstant());
            dates.add(d);
        }
        return dates;
    }

    @Override
    public List<ServiceEntries> selectServiceEntries(Long careRequestsID){
        return ctMapper.selectServiceEntries(careRequestsID);
    }

    @Override
    public void addEntries(Long careRequestId){
        CareRequests careRequests = ctMapper.selectRequestsById(careRequestId);
        ServiceEntries serviceEntries = new ServiceEntries();
        serviceEntries.setCareRequestId(careRequestId);
        serviceEntries.setStartTime(careRequests.getStartTime());
        serviceEntries.setEndTime(careRequests.getEndTime());
        List<Date> dates = CalDates(careRequests.getWeekDay(), Math.toIntExact(careRequests.getTotalDays()));
        for (Date date : dates) {
            serviceEntries.setDate(date);
            ctMapper.addEntries(serviceEntries);
        }
    }

    @Override
    public List<Billing> selectBilling(Long careTakerId){
        return ctMapper.selectBilling(careTakerId);
    }

    @Override
    public void pay(@Param("amount") double amount, @Param("billingId") Long billingId){
        ctMapper.pay(amount, billingId);
    }
}