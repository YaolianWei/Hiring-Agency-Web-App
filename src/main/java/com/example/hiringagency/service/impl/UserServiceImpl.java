package com.example.hiringagency.service.impl;

import com.example.hiringagency.DAO.UserMapper;
import com.example.hiringagency.domain.entity.SecurityQuestionBank;
import com.example.hiringagency.domain.entity.SecurityQuestions;
import com.example.hiringagency.domain.entity.Users;
import com.example.hiringagency.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final String salt = "auogahbvafihvoonafio993";

    @Autowired
    private UserMapper userMapper;

    /**
     * first login
     */
    @Override
    public Users login(@Param("username") String username, @Param("password") String password){
        String pwd = getSalt(password);
        Users user = userMapper.login(username, pwd);
        if (user != null){
            return user;
        }
        return null;
    }

    /**
     * password encryption
     * @param password
     * @return
     */
    private String getSalt(String password) {
        String md5 = password + '/' + salt;
        return DigestUtils.md5DigestAsHex(md5.getBytes());
    }

    public boolean FirstLogin(@Param("userName") String userName){
        boolean hasLogin = userMapper.selectFirstLoginByName(userName);
        return hasLogin;
    }

    public List<SecurityQuestionBank> questionBankList(){
        return userMapper.selectAllQuestions();
    }

    public void setQuestions(SecurityQuestions securityQuestions){
        userMapper.setQuestions(securityQuestions);
    }

    public List<SecurityQuestions> questionsList(@Param("UserID") Long UserID){
        return userMapper.selectQuestionById(UserID);
    }

    public Users selectUserInfo(@Param("userName") String userName){
        return userMapper.selectUserInfoByUserName(userName);
    }
}
