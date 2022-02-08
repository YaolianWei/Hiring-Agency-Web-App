package com.example.hiringagency.service;

import com.example.hiringagency.domain.entity.SecurityQuestionBank;
import com.example.hiringagency.domain.entity.SecurityQuestions;
import com.example.hiringagency.domain.entity.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {

    /**
     * user login
     * @param username
     * @param password
     * @return
     */
    Users login(@Param("username") String username, @Param("password") String password);

    // Users notFirstLogin(@Param("userName") String userName, @Param("password") String password);

    boolean FirstLogin(@Param("userName") String userName);

    List<SecurityQuestionBank> questionBankList();

    void setQuestions(SecurityQuestions securityQuestions);

    List<SecurityQuestions> questionsList(@Param("UserID") Long UserID);

    Users selectUserInfo(@Param("userName")String userName);
}
