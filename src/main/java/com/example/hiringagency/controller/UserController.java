package com.example.hiringagency.controller;

import com.example.hiringagency.domain.entity.SecurityQuestionBank;
import com.example.hiringagency.domain.entity.SecurityQuestions;
import com.example.hiringagency.domain.entity.Users;
import com.example.hiringagency.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * user login
     * @param username
     * @param password
     * @return
     */
    @GetMapping("/login")
    public Map<String,String> login(@Param("username") String username, @Param("password") String password){
        Map<String, String> ret = new HashMap<String, String>();
        Users user = userService.login(username, password);
        if(user != null){
            Boolean hasFirst = userService.FirstLogin(username);
            if(!hasFirst){
                ret.put("code", "200");
                ret.put("isFirst", "true");
                return ret;
            }
            ret.put("code", "200");
            ret.put("isFirst", "false");
            return ret;
        }
        ret.put("code", "400");
        ret.put("msg", "Please enter correct username and password.");
        return ret;
    }

    @PostMapping("/question")
    public List<SecurityQuestionBank> questionBankList(){
        return userService.questionBankList();
    }

    @GetMapping("/setQuestions")
    public Map<String,String> setQuestions(SecurityQuestions securityQuestions){
        Map<String, String> ret = new HashMap<String, String>();
        userService.setQuestions(securityQuestions);

        ret.put("code", "200");
        ret.put("msg", "Set questions success.");
        return ret;
    }

    @GetMapping("/getQuestions")
    public List<SecurityQuestions> questionsList(@Param("UserID") Long UserID){
        return userService.questionsList(UserID);
    }

    @GetMapping("/getUserInfo")
    public Users getUserInfo(@Param("userName") String userName){
        return userService.selectUserInfo(userName);
    }
}
