package com.example.hiringagency.service.impl;

import com.example.hiringagency.DAO.UserMapper;
import com.example.hiringagency.domain.entity.SecurityQuestionBank;
import com.example.hiringagency.domain.entity.SecurityQuestions;
import com.example.hiringagency.domain.entity.Users;
import com.example.hiringagency.domain.model.UserQuestions;
import com.example.hiringagency.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String from;

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

    public List<UserQuestions> questionsList(@Param("UserID") Long UserID){
        return userMapper.selectQuestionById(UserID);
    }

    public Users selectUserInfo(@Param("userName") String userName){
        return userMapper.selectUserInfoByUserName(userName);
    }

    public void updateFirstLogin(@Param("username") String username){
        userMapper.updateFirstLogin(username);
    }

    public void changePassword(@Param("userName") String userName, @Param("password") String password){
        userMapper.changePassword(userName, password);
    }

    public boolean isCorrectPwFormat(String password){
        Boolean isCorrect=false;
        if(password.length()>5){
            String regex=".*[a-zA-Z]+.*";
            Pattern p = Pattern.compile(regex);
            Matcher m= p.matcher(password);
            if (m.find()){
                String regEx="[~!@#$%^&*+]";
                Pattern pattern = Pattern.compile(regEx);
                Matcher matcher = pattern.matcher(password);
                if(matcher.find()){
                    isCorrect = true;
                }
            }
        }
        return isCorrect;
    }

    public boolean isCorrectNumFormat(String phoneNum){
        Boolean isCorrect=false;
        if(phoneNum.length()==10){
            String regEx="1234567890";
            Pattern pattern = Pattern.compile(regEx);
            Matcher matcher = pattern.matcher(phoneNum);
            if(matcher.matches()){
                isCorrect = true;
            }
        }
        return  isCorrect;
    }

    public boolean isCorrectEmaFormat(String email){
        Boolean isCorrect=true;
        String regEx="^([a-z0-9A-Z]+[-|\\\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\\\.)+[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(email);
        if(!matcher.find()){
            isCorrect = false;
        }
        return isCorrect;
    }

    public void deleteSecurityQuestion(@Param("bankQuestionID") Long bankQuestionID, @Param("userID") int userID){
        userMapper.deleteSecurityQuestion(bankQuestionID, userID);
    }

    public void sendEmail(@Param("userName") String userName, @Param("email") String email, @Param("password") String password){
        userMapper.sendEmail(userName, email, password);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(email);
        message.setSubject("Account Information");
        message.setText("Your username is:     "+userName+"\n\n"+"Your password is:      "+password);
        javaMailSender.send(message);
    }

    public void deleteUser(@Param("userName") String userName){
        userMapper.deleteUser(userName);
    }

    public void activateUser(@Param("userName") String userName){
        userMapper.activateUser(userName);
    }

    public void deactivateUser(@Param("userName") String userName){
        userMapper.deactivateUser(userName);
    }
}
