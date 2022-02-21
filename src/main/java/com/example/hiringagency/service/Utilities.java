package com.example.hiringagency.service;

import org.apache.ibatis.annotations.Param;

public interface Utilities {

    void sendEmail(@Param("userName") String userName, @Param("email") String email, @Param("password") String password);

    String randomPassword();

    String getSalt(String password);

    boolean isCorrectNumFormat(@Param("number") String number);

    boolean isCorrectEmaFormat(@Param("email") String email);
}
