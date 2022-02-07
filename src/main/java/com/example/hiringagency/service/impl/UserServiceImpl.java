package com.example.hiringagency.service.impl;

import com.example.hiringagency.DAO.UserMapper;
import com.example.hiringagency.domain.entity.Users;
import com.example.hiringagency.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserServiceImpl implements UserService {

    private final String salt = "auogahbvafihvoonafio993";

    @Autowired
    private UserMapper userMapper;

    /**
     * user login
     * @param userName
     * @param password
     * @return
     */
    @Override
    public Users login(@Param("userName") String userName, @Param("password") String password){
        String pwd = getSalt(password);
        Users user = userMapper.login(userName, pwd);
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

}
