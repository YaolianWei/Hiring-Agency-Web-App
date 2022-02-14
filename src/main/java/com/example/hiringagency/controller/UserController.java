package com.example.hiringagency.controller;

import com.example.hiringagency.domain.entity.SecurityQuestionBank;
import com.example.hiringagency.domain.entity.SecurityQuestions;
import com.example.hiringagency.domain.entity.Users;
import com.example.hiringagency.domain.model.UserQuestions;
import com.example.hiringagency.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import javax.annotation.Resource;
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
                userService.updateFirstLogin(username);
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
    public List<UserQuestions> questionsList(@Param("UserID") Long UserID){
        return userService.questionsList(UserID);
    }

    @GetMapping("/getUserInfo")
    public Users getUserInfo(@Param("userName") String userName){
        return userService.selectUserInfo(userName);
    }

    @PostMapping("/changePassword")
    public Map<String, String> changePassword(@Param("userName") String userName, @Param("password") String password){
        Map<String, String> ret = new HashMap<String, String>();

        boolean isCorrect = userService.isCorrectPwFormat(password);
        if(isCorrect){
            userService.changePassword(userName, password);
            ret.put("code", "200");
            ret.put("msg", "Change password success.");
            return ret;
        } else {
            ret.put("code", "400");
            ret.put("msg", "Change password failure.");
            return ret;
        }
    }

    @GetMapping("/isCorrectNumber")
    public Map<String, String> isCorrectNumFormat(String phoneNum){
        Map<String, String> ret = new HashMap<String, String>();
        boolean isCorrect = userService.isCorrectNumFormat(phoneNum);
        if(isCorrect){
            ret.put("code", "200");
            ret.put("msg", "Correct phone number format.");
            return ret;
        } else {
            ret.put("code", "400");
            ret.put("msg", "Incorrect phone number format.");
            return ret;
        }
    }

    @GetMapping("/isCorrectEmail")
    public Map<String, String> isCorrectEmaFormat(String email){
        Map<String, String> ret = new HashMap<String, String>();
        boolean isCorrect = userService.isCorrectEmaFormat(email);
        if(isCorrect){
            ret.put("code", "200");
            ret.put("msg", "Correct email format.");
            return ret;
        } else {
            ret.put("code", "400");
            ret.put("msg", "Incorrect email format.");
            return ret;
        }
    }

    @GetMapping("/deleteQuestion")
    public Map<String, String> deleteSecurityQuestion(@Param("bankQuestionID") Long bankQuestionID, @Param("userID") int userID){
        Map<String, String> ret = new HashMap<String, String>();
        userService.deleteSecurityQuestion(bankQuestionID, userID);
        ret.put("code", "200");
        ret.put("msg", "Delete security question success.");
        return ret;
    }

    @PostMapping("/sendEmail")
    public Map<String, String> sendEmail(@Param("userName") String userName, @Param("email") String email, @Param("password") String password){
        Map<String, String> ret = new HashMap<String, String>();
        userService.sendEmail(userName, email, password);
        ret.put("code", "200");
        ret.put("msg", "Send email success.");
        return ret;
    }

    @GetMapping("/deleteUser")
    public Map<String, String> deleteUser(@Param("userName") String userName){
        Map<String, String> ret = new HashMap<String, String>();
        userService.deleteUser(userName);
        ret.put("code", "200");
        ret.put("msg", "Delete user success.");
        return ret;
    }

    @GetMapping("/activateUser")
    public Map<String, String> activateUser(@Param("userName") String userName){
        Map<String, String> ret = new HashMap<String, String>();
        userService.activateUser(userName);
        ret.put("code", "200");
        ret.put("msg", "Activate user success.");
        return ret;
    }

    @GetMapping("/deactivateUser")
    public Map<String, String> deactivateUser(@Param("userName") String userName){
        Map<String, String> ret = new HashMap<String, String>();
        userService.deactivateUser(userName);
        ret.put("code", "200");
        ret.put("msg", "Deactivate user success.");
        return ret;
    }
}
