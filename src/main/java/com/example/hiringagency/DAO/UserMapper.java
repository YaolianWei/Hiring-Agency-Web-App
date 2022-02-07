package com.example.hiringagency.DAO;

import com.example.hiringagency.domain.entity.SecurityQuestionBank;
import com.example.hiringagency.domain.entity.SecurityQuestions;
import com.example.hiringagency.domain.entity.Users;
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

    Boolean selectFirstLoginByName(@Param("userName")String userName);

    List<SecurityQuestionBank> selectAllQuestions();

    void setQuestions(SecurityQuestions securityQuestions);

    List<SecurityQuestions> selectQuestionById(@Param("UserID") String UserID);

}
