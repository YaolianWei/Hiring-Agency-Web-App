package com.example.hiringagency.service.impl;

import com.example.hiringagency.DAO.StaffMapper;
import com.example.hiringagency.domain.entity.*;
import com.example.hiringagency.domain.model.Info;
import com.example.hiringagency.service.StaffService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffMapper staffMapper;

    @Override
    public void setAd(JobAdvertisements jobAdvertisements) {
        staffMapper.setAd(jobAdvertisements);
    }

    @Override
    public List<JobAdvertisements> viewAllAds(){
        return staffMapper.selectAllAds();
    }

    @Override
    public void deleteAd(@Param("jobAdvertisementId") long jobAdvertisementId) {
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
    public List<Users> allHP(){
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
    public List<HealthcareJobApplication> assignHPList(@Param("careRequestId") Long careRequestId, @Param("serviceEntryId") Long serviceEntryId){
        CareRequests cr = staffMapper.selectRequestById(careRequestId);//得到CareRequests
        Date date = staffMapper.selectEntriesById(serviceEntryId).getDate();//根据serviceEntry得到日期
        List<HealthcareJobApplication> hpList = staffMapper.selectHPbyRequest(cr.getServiceType(), cr.getGenderSpecific());//得到符合类型和性别的HP
        for (HealthcareJobApplication hja : hpList) {
            int hpAge = getAge(hja.getDateOfBirth());
            if (hpAge < cr.getLowerAgeLimit() || hpAge > cr.getUpperAgeLimit()){
                hpList.remove(hja);//删去年龄不符合要求的HP
            }
        }
        for (HealthcareJobApplication hja : hpList) {
            List<ServiceEntries> seList = staffMapper.selectEntriesByHp(hja.getUserId());
            for (ServiceEntries se : seList) {
                if (se.getDate() == date){//如果HP在这一天有服务
                    if (DateUtil.overlapped(
                                DateUtil.buildSlot(cr.getStartTime(), cr.getEndTime()),
                                DateUtil.buildSlot(se.getStartTime(), se.getEndTime())
                    )) {
                        hpList.remove(hja);//重合，删去
                    }
                }
            }
        }
        int patientAge = getAge(cr.getDateOfBirth());
        if (patientAge > 59 && cr.getServiceType() == 2){
            hpList.removeIf(hja -> hja.getDegree() < 2);//如果病人大于60岁，且需要type为2的服务，删去学历不为2的HP
        }
        return hpList;
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
        staffMapper.addBilling(billing);
    }

    @Override
    public List<Billing> selectBilling(){
        return staffMapper.selectBilling();
    }

    @Override
    public void pay(@Param("amount") double amount, @Param("billingId") Long billingId){
        staffMapper.pay(amount, billingId);
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
            staffMapper.softDeleteCT(careTakerId);
        }
        return canDelete;
    }

    @Override
    public List<CareRequests> selectRequestByCt(@Param("careTakerId") Long careTakerId){
        return staffMapper.selectRequestByCt(careTakerId);
    }

    @Override
    public void withdraw(@Param("careRequestId") long careRequestId){
        List<ServiceEntries> seList = staffMapper.selectServiceEntries(careRequestId);
        Date date = new Date();
        for (ServiceEntries se : seList) {
            if (se.getDate().compareTo(date)>0){
                staffMapper.withdraw(se.getServiceEntryId());
            }
        }
    }

    @Override
    public void updateHour(@Param("startTime")Timestamp startTime, @Param("endTime")Timestamp endTime, @Param("serviceEntryId")Long serviceEntryId){
        staffMapper.updateHour(startTime, endTime, serviceEntryId);
    }
}
