package com.example.hiringagency.service;

import com.example.hiringagency.domain.entity.SecurityQuestionBank;
import com.example.hiringagency.domain.entity.SecurityQuestions;
import com.example.hiringagency.domain.entity.Users;
import com.example.hiringagency.domain.model.UserQuestions;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

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

    boolean FirstLogin(@Param("username") String username);

    List<SecurityQuestionBank> questionBankList();

    void setQuestions(SecurityQuestions securityQuestions);

    List<UserQuestions> questionsList(@Param("userId") Long userId);

    Users selectUserInfo(@Param("username")String username);

    void updateFirstLogin(@Param("username") String username);

    void changePassword(@Param("username") String username, @Param("password") String password);

    boolean isCorrectPwFormat(String password);

    void deleteSecurityQuestion(@Param("bankQuestionId") Long bankQuestionId, @Param("userId")Long userId);

    void deleteUser(@Param("username") String username);

    void activateUser(@Param("username") String username);

    void deactivateUser(@Param("username") String username);

    Long checkExistQuestion(@Param("bankQuestionId") Long bankQuestionId, @Param("userId") Long userId);

    void softDeleteUser(@Param("username") String username);
}
