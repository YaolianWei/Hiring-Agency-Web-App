package com.example.hiringagency.DAO;

import com.example.hiringagency.domain.entity.SecurityQuestionBank;
import com.example.hiringagency.domain.entity.SecurityQuestions;
import com.example.hiringagency.domain.entity.Users;
import com.example.hiringagency.domain.model.UserQuestions;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Mapper
@Repository
public interface UserMapper {

    /**
     * Query user and verify login based on name and password
     */
    Users login(@Param("username") String username, @Param("password") String password);

    Boolean selectIsBlockedByName(@Param("username") String username);

    Boolean selectFirstLoginByName(@Param("username")String username);

    List<SecurityQuestionBank> selectAllQuestions();

    void setQuestions(@RequestBody SecurityQuestions securityQuestions);

    List<UserQuestions> selectQuestionById(@Param("userId") Long userId);

    Users selectUserInfoByUserName(@Param("username")String username);

    void changePassword(@Param("username") String username, @Param("password") String password);

    void deleteSecurityQuestion(@Param("bankQuestionId") Long bankQuestionId, @Param("userId") Long userId);

    void deleteUser(@Param("username") String username);

    void activateUser(@Param("username") String username);

    void deactivateUser(@Param("username") String username);

    Long selectQuestionIdById(@Param("bankQuestionId") Long bankQuestionId, @Param("userId") Long userId);

    void softDeleteUser(@Param("username") String username);
}
