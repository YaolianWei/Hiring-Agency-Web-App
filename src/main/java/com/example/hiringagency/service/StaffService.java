package com.example.hiringagency.service;

import com.example.hiringagency.domain.entity.JobAdvertisements;
import com.example.hiringagency.domain.entity.Users;
import com.example.hiringagency.domain.model.HPInfo;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface StaffService {
    void setAd(JobAdvertisements jobAdvertisements);

    List<JobAdvertisements> viewAllAds();

    void deleteAd(@Param("jobAdvertisementID") long AdvertisementID);

    void addHPAccount(String firstName, String lastName, String username, String password, String postalAddress, Long phoneNumber, String email);

    // hire HP - 1
    HPInfo selectInfoById(@Param("healthcareJobApplicationId") Long healthcareJobApplicationId);

    // hire HP - 2
    Long maxId();

    // hire HP - 3
    void updateUserId(@Param("userId") Long userId, @Param("healthcareJobApplicationId") Long healthcareJobApplicationId);

    List<Users> allHP();

}
