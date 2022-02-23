package com.example.hiringagency.service;

import com.example.hiringagency.domain.entity.SecurityQuestionBank;
import com.example.hiringagency.domain.entity.SecurityQuestions;
import com.example.hiringagency.domain.entity.Users;
import com.example.hiringagency.domain.model.UserPassword;
import com.example.hiringagency.domain.model.UserQuestions;
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

    boolean IsBlocked(@Param("username") String username);

    boolean FirstLogin(@Param("userName") String userName);

    List<SecurityQuestionBank> questionBankList();

    void setQuestions(SecurityQuestions securityQuestions);

    List<UserQuestions> questionsList(@Param("UserID") Long UserID);

    Users selectUserInfo(@Param("userName")String userName);

    void updateFirstLogin(@Param("username") String username);

    void changePassword(@Param("username") String username, @Param("password") String password);

    boolean isCorrectPwFormat(String password);

    void deleteSecurityQuestion(@Param("bankQuestionID") Long bankQuestionID, @Param("userID")Long userID);

    void deleteUser(@Param("userName") String userName);

    void activateUser(@Param("userName") String userName);

    void deactivateUser(@Param("userName") String userName);
}
