package com.example.hiringagency.service.impl;

import com.example.hiringagency.service.Utilities;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UtilitiesImpl implements Utilities {

    private final String salt = "auogahbvafihvoonafio993";

    @Resource
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String from;

    @Override
    public void sendEmail(@Param("username") String username, @Param("email") String email, @Param("password") String password){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(email);
        message.setSubject("Account Information");
        message.setText("Welcome to Hiring Agency! "+"\r\n\n" + "Your username is:     " + username + "\n" + "Your password is:      "+password);
        javaMailSender.send(message);
    }

    @Override
    public String randomPassword(){
        String str1 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String str2 = "~!@#$%&*+";
        Random random = new Random();
        StringBuilder stringBuffer = new StringBuilder();
        for (int i= 0; i < 6; i++){
            int number = random.nextInt(52);
            stringBuffer.append(str1.charAt(number));
        }
        int num = random.nextInt(10);
        stringBuffer.append(str2.charAt(num));
        return stringBuffer.toString();
    }

    /**
     * password encryption
     */
    public String getSalt(String password) {
        String md5 = password + '/' + salt;
        return DigestUtils.md5DigestAsHex(md5.getBytes());
    }

    @Override
    public boolean isCorrectNumFormat(String phoneNum){
        boolean isCorrect=false;
        if(phoneNum.length()==10){
            if(phoneNum.matches("[0-9]+")){
                isCorrect = true;
            }
        }
        return  isCorrect;
    }

    @Override
    public boolean isCorrectEmaFormat(String email){
        boolean isCorrect=true;
        String regEx="\\w{3,15}@(\\w{2,8}\\.){1,2}(com|net|cn|edu)";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(email);
        if(!matcher.matches()){
            isCorrect = false;
        }
        return isCorrect;
    }
}
