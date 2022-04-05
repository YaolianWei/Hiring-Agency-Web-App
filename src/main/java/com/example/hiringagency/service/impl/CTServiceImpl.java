package com.example.hiringagency.service.impl;

import com.example.hiringagency.DAO.CTMapper;
import com.example.hiringagency.domain.entity.*;
import com.example.hiringagency.domain.model.BillingAccountInfo;
import com.example.hiringagency.domain.model.BillingDetails;
import com.example.hiringagency.domain.model.EntriesDetails;
import com.example.hiringagency.service.CTService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
            if ((cr.getFirstName().equals(careRequests.getFirstName())) && (cr.getLastName().equals(careRequests.getLastName())) && (cr.getDateOfBirth().equals(careRequests.getDateOfBirth())) && (cr.getServiceType().equals(careRequests.getServiceType()))) {
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
//            DateFormat sdf = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss.SSS");
//            careRequests.setStartTime(new Strftime("%y:%m:%d %h:%m:%s.S", new Locale(sdf.format(new Date(careRequests.getStartTime().getTime()))) ));
            ctMapper.addRequest(careRequests);
            ServiceEntries serviceEntries = new ServiceEntries();
            serviceEntries.setCareRequestId(ctMapper.selectMaxId());
            serviceEntries.setStartTime(careRequests.getStartTime());
            serviceEntries.setEndTime(careRequests.getEndTime());
            List<Date> dates = CalDates(careRequests.getWeekDay(), Math.toIntExact(careRequests.getTotalDays()));
            for (Date date : dates) {
                serviceEntries.setDate(date);
                ctMapper.addEntries(serviceEntries);
            }
        }
        return canAdd;
    }

    @Override
    public List<CareRequests> selectRequests(Long careTakerId){
        return ctMapper.selectRequests(careTakerId);
    }

    public List<Date> CalDates(String weekDays, int days) {
        String[] weekDay;
        String delimeter = ",";
        weekDay = weekDays.split(delimeter);
        ArrayList<LocalDate> localDates = new ArrayList<>();
        int weeks  = days / weekDay.length + 1;
        for (String weekday : weekDay) {
            LocalDate date;
            if (weekday.equals("0")) {
                date = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.of(7)));
            }else {
                date = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.of(Integer.parseInt(weekday))));
            }
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
    public List<EntriesDetails> entriesDetails(Long careRequestsID){
        return ctMapper.selectEntriesDetails(careRequestsID);
    }

    @Override
    public List<BillingAccountInfo> selectBilling(Long careTakerId){
        return ctMapper.selectBilling(careTakerId);
    }

    @Override
    public List<BillingDetails> selectCompleteEntriesByRequest(@Param("careRequestId") Long careRequestId){
        List<BillingDetails> bdList = ctMapper.selectCompleteEntriesByRequest(careRequestId);
        double hourlyRate = ctMapper.selectRateByRequest(careRequestId);
        for (BillingDetails bd : bdList) {
            long time1 = bd.getStartTime().getTime();
            long time2 = bd.getEndTime().getTime();
            double hours = (double) ((time2 - time1) / (1000*60*60));
            double minutes = (double) (((time2 - time1) / 1000 - hours*(60*60)) / 60);
            double hour = hours + minutes/60;
            double amount = mul(hour, hourlyRate);
            amount = (double) Math.round(amount * 100) / 100;
            bd.setAmount(amount);
        }
        return bdList;
    }

    public double mul(double d1,double d2){
        BigDecimal bd1 = new BigDecimal(Double.toString(d1));
        BigDecimal bd2 = new BigDecimal(Double.toString(d2));
        return bd1.multiply(bd2).doubleValue();
    }

    @Override
    public boolean withdraw(@Param("careRequestId") Long careRequestId){
        boolean canWithdraw = false;
        Billing billing = ctMapper.selectBillingByRequest(careRequestId);
        if (billing.getAmountYetToPay().equals(billing.getPaidAmount())){
            canWithdraw = true;
            ctMapper.withdraw(careRequestId);
        }
        return canWithdraw;
    }

    @Override
    public List<CTPayment> selectCTPaymentById(@Param("billingId")Long billingId){
        return ctMapper.selectCTPaymentById(billingId);
    }
}