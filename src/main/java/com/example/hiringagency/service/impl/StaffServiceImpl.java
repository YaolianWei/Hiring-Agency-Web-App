package com.example.hiringagency.service.impl;

import com.example.hiringagency.DAO.HPMapper;
import com.example.hiringagency.DAO.StaffMapper;
import com.example.hiringagency.domain.entity.*;
import com.example.hiringagency.domain.model.BillingAccountInfo;
import com.example.hiringagency.domain.model.HPAccountInfo;
import com.example.hiringagency.domain.model.HPDetails;
import com.example.hiringagency.domain.model.Info;
import com.example.hiringagency.service.StaffService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private HPMapper hpMapper;

    @Override
    public void setAd(JobAdvertisements jobAdvertisements) {
        staffMapper.setAd(jobAdvertisements);
    }

    @Override
    public List<JobAdvertisements> viewAllAds(){
        return staffMapper.selectAllAds();
    }

    @Override
    public void deleteAd(@Param("jobAdvertisementId") Long jobAdvertisementId) {
        staffMapper.deleteAd(jobAdvertisementId);
    }

    // hire HP - 一
    @Override
    public void addHPAccount(String firstName, String lastName, String username, String password, String postalAddress, Long phoneNumber, String email, Double hourlyRate) {
        staffMapper.addHPAccount(firstName, lastName, username, password, postalAddress, phoneNumber, email, hourlyRate);
    }

    // hire HP - 1
    @Override
    public Info selectHPInfoById(@Param("healthcareJobApplicationId") Long healthcareJobApplicationId){
        return staffMapper.selectHPInfoById(healthcareJobApplicationId);
    }

    // hire HP - 2
    @Override
    public Long maxId(){
        return staffMapper.selectMaxId();
    }

    // hire HP - 3
    @Override
    public void updateHPId(@Param("userId") Long userId, @Param("healthcareJobApplicationId") Long healthcareJobApplicationId){
        staffMapper.updateHPId(userId, healthcareJobApplicationId);
    }

    @Override
    public List<HPDetails> allHP(){
        return staffMapper.selectAllHP();
    }

    @Override
    public void addCTAccount(String firstName, String lastName, String username, String password, String postalAddress, Long phoneNumber, String email) {
        staffMapper.addCTAccount(firstName, lastName, username, password, postalAddress, phoneNumber, email);
    }

    @Override
    public Info selectCTInfoById(@Param("careTakerRegistrationId") Long careTakerRegistrationId){
        return staffMapper.selectCTInfoById(careTakerRegistrationId);
    }

    @Override
    public void updateCTId(@Param("userId") Long userId, @Param("careTakerRegistration") Long careTakerRegistration){
        staffMapper.updateCTId(userId, careTakerRegistration);
    }

    @Override
    public List<Users> allCT(){
        return staffMapper.selectAllCT();
    }

    @Override
    public List<CareRequests> requestsList(){
        return staffMapper.selectAllRequests();
    }

    @Override
    public List<ServiceEntries> selectServiceEntries(Long careRequestsID){
        return staffMapper.selectServiceEntries(careRequestsID);
    }

    @Override
    public boolean selectBillingByRequest(@Param("careRequestId") Long careRequestId){
        List<Billing> list = staffMapper.selectBillingByRequest(careRequestId);
        boolean hasBilling;
        hasBilling = list.size() != 0;
        return hasBilling;
    }

    @Override
    public List<HealthcareJobApplication> assignHPList(@Param("careRequestId") Long careRequestId, @Param("serviceEntryId") Long serviceEntryId){
        CareRequests cr = staffMapper.selectRequestById(careRequestId);
        ServiceEntries serviceEntries = staffMapper.selectEntriesById(serviceEntryId);
        Date date = serviceEntries.getDate();
        List<HealthcareJobApplication> hpList;
        if(cr.getGenderSpecific() != null){
            hpList = staffMapper.selectHPbyRequest(cr.getServiceType(), cr.getGenderSpecific());
        } else {
            hpList = staffMapper.selectHPbyType(cr.getServiceType());
        }
        List<HealthcareJobApplication> hpList1 = new ArrayList<>();
        if(hpList.size() > 0){
            for (HealthcareJobApplication hja : hpList) {
                int hpAge = getAge(hja.getDateOfBirth());
                if(hpList.size() > 0){
                    if (cr.getLowerAgeLimit() != null) {
                        if (hpAge >= cr.getLowerAgeLimit()) {
                            if(cr.getUpperAgeLimit() != null){
                                if (hpAge <= cr.getUpperAgeLimit()){
                                    hpList1.add(hja);
                                }
                            } else {
                                hpList1.add(hja);
                            }
                        }
                    } else {
                        if(cr.getUpperAgeLimit() != null){
                            if (hpAge <= cr.getUpperAgeLimit()){
                                hpList1.add(hja);
                            }
                        } else {
                            hpList1.add(hja);
                        }
                    }
                }
            }
            if( hpList1.size() == 0 ){
                return hpList1;
            }
        }

        List<HealthcareJobApplication> hpList2 = new ArrayList<>();
        if(hpList1.size() > 0){
            for (HealthcareJobApplication hja : hpList1) {
                List<ServiceEntries> seList = staffMapper.selectEntriesByHp(hja.getUserId());
                if (seList.size() == 0){
                    hpList2.add(hja);
                } else {
                    boolean notOverlap = true;
                    for (ServiceEntries se : seList) {
                        if (Objects.equals(se.getDate(), date)) {
                            if (DateUtil.overlapped(
                                    DateUtil.buildSlot(serviceEntries.getStartTime(), serviceEntries.getEndTime()),
                                    DateUtil.buildSlot(se.getStartTime(), se.getEndTime())
                            )) {
                                notOverlap = false;
                                break;
                            }
                        }
                    }
                    if(notOverlap){
                        hpList2.add(hja);
                    }
                }
            }
        }
//        if(hpList.size() > 0){
//            for (HealthcareJobApplication hja : hpList) {
//                int hpAge = getAge(hja.getDateOfBirth());
//                if(hpList.size() > 0){
//                    if (cr.getLowerAgeLimit() != null) {
//                        if (hpAge < cr.getLowerAgeLimit()) {
//                            hpList.remove(hja);
//                        }
//                    }
//                }
//                if(hpList.size() > 0){
//                    if(cr.getUpperAgeLimit() != null){
//                        if (hpAge > cr.getUpperAgeLimit()){
//                            hpList.remove(hja);
//                        }
//                    }
//                }
//                if( hpList.size() == 0 ){
//                    return hpList;
//                }
//            }
//        }

//        if(hpList.size() > 0){
//            for (HealthcareJobApplication hja : hpList) {
//                List<ServiceEntries> seList = staffMapper.selectEntriesByHp(hja.getUserId());
//                if ( seList.size() == 0 ){
//                    break;
//                }
//                for (ServiceEntries se : seList) {
//                    if (Objects.equals(se.getDate(), date)) {
//                        if (DateUtil.overlapped(
//                                DateUtil.buildSlot(cr.getStartTime(), cr.getEndTime()),
//                                DateUtil.buildSlot(se.getStartTime(), se.getEndTime())
//                        )) {
//                            hpList.remove(hja);
//                            break;
//                        }
//                        if( hpList.size() == 0 ){
//                            return hpList;
//                        }
//                    }
//                }
//            }
//        }
        int patientAge = getAge(cr.getDateOfBirth());
        if(hpList2.size() > 0){
            if (patientAge > 59 && cr.getServiceType() == 3){
                hpList2.removeIf(hja -> hja.getDegree() < 3);
            }
        }
        return hpList2;
    }

    public int getAge(Date birthDay){
        Calendar cal = Calendar.getInstance();
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthDay);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
        int age = yearNow - yearBirth;
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) age--;
            }else{
                age--;
            }
        }
        return age;
    }

    public static class DateUtil {

        public static boolean overlapped(TimeSlot slot1, TimeSlot slot2) {
            TimeSlot previous, next;
            previous = slot1.startTime.before(slot2.startTime) ? slot1 : slot2;
            next = slot2.startTime.after(slot1.startTime) ? slot2 : slot1;
            return !(le(previous, next) || ge(previous, next));
        }

        public static TimeSlot buildSlot(Timestamp startTime, Timestamp endTime) {
            return new TimeSlot(startTime, endTime);
        }

        private static boolean le(TimeSlot prev, TimeSlot next) {
            return lt(prev, next) || next.endTime.equals(prev.startTime);
        }

        private static boolean ge(TimeSlot prev, TimeSlot next) {
            return gt(prev, next) || prev.endTime.equals(next.startTime);
        }

        private static boolean gt(TimeSlot prev, TimeSlot next) {
            return prev.endTime.before(next.startTime);
        }

        private static boolean lt(TimeSlot prev, TimeSlot next) {
            return next.endTime.before(prev.startTime);
        }

        static class TimeSlot{
            private final Timestamp startTime;
            private final Timestamp endTime;

            public TimeSlot(Timestamp startTime, Timestamp endTime) {
                if (startTime.after(endTime)) {
                    this.startTime = endTime;
                    this.endTime = startTime;
                } else {
                    this.startTime = startTime;
                    this.endTime = endTime;
                }
            }
        }
    }

    @Override
    public void assignHP(@Param("userId") Long userId, @Param("serviceEntryId") Long serviceEntryId){
        staffMapper.assignHP(userId, serviceEntryId);
    }

    @Override
    public List<ServiceEntries> selectEntriesByHp (@Param("userId") Long userId){
        return staffMapper.selectEntriesByHp(userId);
    }

    @Override
    public void deAssignHP(@Param("serviceEntryId") Long serviceEntryId){
        staffMapper.deAssignHP(serviceEntryId);
    }

    @Override
    public void addBilling(Billing billing){
        if (staffMapper.selectMaxServiceId() == null){
            billing.setServiceId(1000L);
        } else {
            billing.setServiceId(staffMapper.selectMaxServiceId() + 1);
        }
        staffMapper.addBilling(billing);
    }

    @Override
    public List<BillingAccountInfo> selectBilling(){
        return staffMapper.selectBilling();
    }

    @Override
    public boolean pay(@Param("amount") double amount, @Param("billingId") Long billingId){
        double paidAmount = staffMapper.selectPaidById(billingId);
        double sum = sum(paidAmount, amount);
        sum = (double) Math.round(sum * 100) / 100;
        Date date = new Date();
        if (sum >= 0){
            staffMapper.pay(sum, billingId);
            staffMapper.addCTPayment(amount, date, billingId);
            double amountYetToPay = staffMapper.selectCostById(billingId);
            amount = 0 - amount;
            amountYetToPay = sum(amountYetToPay, amount);
            staffMapper.updateCost(billingId, amountYetToPay);
            Billing billing = staffMapper.selectBillingById(billingId);
            List<ServiceEntries> seList = hpMapper.selectServiceEntries(billing.getCareRequestId());
            boolean canUpdate = true;
            if(billing.getAmountYetToPay() == 0){
                for (ServiceEntries ses : seList){
                    if ((ses.getDate().compareTo(date) > 0) || (ses.getStatus() == 1)) {
                        canUpdate = false;
                        break;
                    }
                }
            } else {
                canUpdate = false;
            }
            if (canUpdate){
                hpMapper.terminate(billing.getCareRequestId());
            }

            return true;
        } else {
            return false;
        }
    }

    public double sum(double d1,double d2){
        BigDecimal bd1 = new BigDecimal(Double.toString(d1));
        BigDecimal bd2 = new BigDecimal(Double.toString(d2));
        return bd1.add(bd2).doubleValue();
    }

    @Override
    public Boolean softDeleteCT(@Param("careTakerID") Long careTakerId){
        boolean canDelete = true;
        Date date = new Date();
        List<CareRequests> crList = staffMapper.selectRequestByCt(careTakerId);
        for (CareRequests cr : crList) {
            List<ServiceEntries> seList = staffMapper.selectServiceEntries(cr.getCareRequestId());
            for (ServiceEntries se : seList) {
                if (se.getDate().compareTo(date) > 0) {
                    canDelete = false;
                    break;
                }
            }
        }
        if (canDelete){
            long userId = careTakerId;
            staffMapper.softDeleteUser(userId);
        }
        return canDelete;
    }

    @Override
    public List<CareRequests> selectRequestByCt(@Param("careTakerId") Long careTakerId){
        return staffMapper.selectRequestByCt(careTakerId);
    }

    @Override
    public void withdraw(@Param("careRequestId") long careRequestId){
        staffMapper.terminate(careRequestId);
        List<ServiceEntries> seList = staffMapper.selectServiceEntries(careRequestId);
        Date date = new Date();
        for (ServiceEntries se : seList) {
            if (se.getDate().compareTo(date) > 0){
                staffMapper.withdraw(se.getServiceEntryId());
            }
        }
    }

    @Override
    public void updateHour(@RequestBody ServiceEntries serviceEntries){
        staffMapper.updateHour(serviceEntries);
    }

    @Override
    public Boolean softDeleteHP(@Param("hpId") Long hpId){
        boolean canDelete = false;
        HPAccount hpa = staffMapper.selectHPAccountById(hpId);
        if (hpa.getAmountYetToPay() == 0){
            canDelete = true;
            long userId = hpId;
            staffMapper.softDeleteUser(userId);
        }
        return canDelete;
    }

    @Override
    public boolean payHP(@Param("amount") double amount, @Param("hpId") Long hpId){
        long userId = hpId;
        HPAccount hpa = staffMapper.selectHPAccountById(userId);
        double paidAmount = hpa.getAmountPaid();
        double sum = sum(paidAmount, amount);
        sum = (double) Math.round(sum * 100) / 100;
        if (sum >= 0){
            staffMapper.payHP(sum, hpId);
            Date date = new Date();
            staffMapper.addHPPayment(amount, date, hpId);
            double amountYetToPay = hpa.getAmountYetToPay();
            amount = 0 - amount;
            amountYetToPay = sum(amountYetToPay, amount);
            staffMapper.updateSalary(hpId, amountYetToPay);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<HPAccountInfo> selectHPAccount() {
        return staffMapper.selectHPAccount();
    }

    @Override
    public List<CareRequests> selectWithdrawRequests(){
        return staffMapper.selectWithdrawRequests();
    }

    @Override
    public List<CareRequests> selectTerminateRequests(){
        return staffMapper.selectTerminateRequests();
    }
}