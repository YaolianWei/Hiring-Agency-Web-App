package com.example.hiringagency.DAO;

import com.example.hiringagency.domain.entity.SecurityQuestionBank;
import com.example.hiringagency.domain.entity.SecurityQuestions;
import com.example.hiringagency.domain.entity.Users;
import com.example.hiringagency.domain.model.UserQuestions;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface UserMapper {

    /**
     * Query user and verify login based on name and password
     */
    Users login(@Param("username") String username, @Param("password") String password);

    // Users notFirstLogin(@Param("userName") String userName, @Param("password") String password);

    Boolean selectIsBlockedByName(@Param("username") String username);

    Boolean selectFirstLoginByName(@Param("userName")String userName);

    List<SecurityQuestionBank> selectAllQuestions();

    void setQuestions(SecurityQuestions securityQuestions);

    List<UserQuestions> selectQuestionById(@Param("UserID") Long UserID);

    Users selectUserInfoByUserName(@Param("userName")String userName);

    void updateFirstLogin(@Param("username") String username);

    void changePassword(@Param("userName") String userName, @Param("password") String password);

    void deleteSecurityQuestion(@Param("bankQuestionID") Long bankQuestionID, @Param("userID") Long userID);

    void deleteUser(@Param("userName") String userName);

    void activateUser(@Param("userName") String userName);

    void deactivateUser(@Param("userName") String userName);
}
