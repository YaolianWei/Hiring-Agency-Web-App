package com.example.hiringagency.controller;

import com.example.hiringagency.domain.entity.Users;
import com.example.hiringagency.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * user login
     * @param userName
     * @param password
     * @return
     */
    @PostMapping("/login")
    public Users login(@Param("userName") String userName, @Param("password") String password){
        Users user = userService.login(userName, password);
        return user;
    }
}
