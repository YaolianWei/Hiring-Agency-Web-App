package com.example.hiringagency.service;

import com.example.hiringagency.domain.entity.Users;
import org.apache.ibatis.annotations.Param;

public interface UserService {

    /**
     * user login
     * @param userName
     * @param password
     * @return
     */
    Users login(@Param("userName") String userName, @Param("password") String password);
}
