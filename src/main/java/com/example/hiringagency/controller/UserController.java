package com.example.hiringagency.controller;

import com.example.hiringagency.domain.entity.SecurityQuestionBank;
import com.example.hiringagency.domain.entity.SecurityQuestions;
import com.example.hiringagency.domain.entity.Users;
import com.example.hiringagency.domain.model.UserPassword;
import com.example.hiringagency.domain.model.UserQuestions;
import com.example.hiringagency.service.UserService;
import com.example.hiringagency.service.Utilities;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private Utilities utilities;

    /**
     * user login
     * @return
     */
    @PostMapping("/login")
    public Map<String,String> login(@RequestBody HashMap<String, String> map){
        Map<String, String> ret = new HashMap<String, String>();
        Users user = userService.login(map.get("username"), map.get("password"));
        if(user != null){
            Boolean isBlocked = userService.IsBlocked(map.get("username"));
            if(!isBlocked){
                Boolean hasFirst = userService.FirstLogin(map.get("username"));
                if(!hasFirst){
                    userService.updateFirstLogin(map.get("username"));
                    ret.put("code", "200");
                    ret.put("isFirst", "true");
                    return ret;
                }
                ret.put("code", "200");
                ret.put("isFirst", "false");
                return ret;
            } else {
                ret.put("code", "402");
                ret.put("msg", "You account has been blocked, please contact admin.");
                return ret;
            }

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
        Long exist = userService.checkExistQuestion(securityQuestions.getBankQuestionId(), securityQuestions.getUserId());
        if( exist == null){
            userService.setQuestions(securityQuestions);

            ret.put("code", "200");
            ret.put("msg", "Set questions success.");
        } else {
            ret.put("code", "400");
            ret.put("msg", "You have chosen this security question.");
        }
        return ret;
    }


    @GetMapping("/getQuestions")
    public List<UserQuestions> questionsList(@Param("userId") Long userId){
        return userService.questionsList(userId);
    }

    @GetMapping("/getUserInfo")
    public Users getUserInfo(@Param("username") String username){
        return userService.selectUserInfo(username);
    }

    @PostMapping("/changePassword")
    public Map<String, String> changePassword(@RequestBody UserPassword userPassword){
        Map<String, String> ret = new HashMap<String, String>();

        boolean isCorrect = userService.isCorrectPwFormat(userPassword.getPassword());
        if(isCorrect){
            String pwd = utilities.getSalt(userPassword.getPassword());
            userService.changePassword(userPassword.getUsername(), pwd);
            ret.put("code", "200");
            ret.put("msg", "Change password success.");
            return ret;
        } else {
            ret.put("code", "400");
            ret.put("msg", "The password you entered is not in the correct format.");
            return ret;
        }
    }

    @GetMapping("/deleteQuestion")
    public Map<String, String> deleteSecurityQuestion(@Param("bankQuestionId") Long bankQuestionId, @Param("userId") Long userId){
        Map<String, String> ret = new HashMap<String, String>();
        userService.deleteSecurityQuestion(bankQuestionId, userId);
        ret.put("code", "200");
        ret.put("msg", "Delete security question success.");
        return ret;
    }

    @GetMapping("/deleteUser")
    public Map<String, String> deleteUser(@Param("username") String username){
        Map<String, String> ret = new HashMap<String, String>();
        userService.deleteUser(username);
        ret.put("code", "200");
        ret.put("msg", "Delete user success.");
        return ret;
    }

    @GetMapping("/activateUser")
    public Map<String, String> activateUser(@Param("username") String username){
        Map<String, String> ret = new HashMap<String, String>();
        userService.activateUser(username);
        ret.put("code", "200");
        ret.put("msg", "Activate user success.");
        return ret;
    }

    @GetMapping("/blockUser")
    public Map<String, String> blockUser(@Param("username") String username){
        Map<String, String> ret = new HashMap<String, String>();
        userService.deactivateUser(username);
        ret.put("code", "200");
        ret.put("msg", "Deactivate user success.");
        return ret;
    }

    @GetMapping("/softDeleteUser")
    public Map<String, String> softDeleteUser(@Param("username") String username){
        Map<String, String> ret = new HashMap<String, String>();
        userService.softDeleteUser(username);
        ret.put("code", "200");
        ret.put("msg", "Delete user success.");
        return ret;
    }
}
