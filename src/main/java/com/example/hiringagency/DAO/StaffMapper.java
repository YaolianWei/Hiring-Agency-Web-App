package com.example.hiringagency.DAO;

import com.example.hiringagency.domain.entity.JobAdvertisements;
import com.example.hiringagency.domain.entity.Users;
import com.example.hiringagency.domain.model.HPInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StaffMapper {
    void setAd(JobAdvertisements jobAdvertisements);

    List<JobAdvertisements> selectAllAds();

    void deleteAd(@Param("jobAdvertisementID") long jobAdvertisementID);

    void addHPAccount(String firstName, String lastName, String username, String password, String postalAddress, Long phoneNumber, String email);

    // hire HP - 1
    HPInfo selectInfoById(@Param("healthcareJobApplicationId") Long healthcareJobApplicationId);

    // hire HP - 2
    Long selectMaxId();

    // hire HP - 3
    void updateUserId(@Param("userId") Long userId, @Param("healthcareJobApplicationId") Long healthcareJobApplicationId);
}
