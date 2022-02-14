package com.example.hiringagency.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * @Description
 * @Author Yaolian
 * @Date 2022-02-06
 */

@Data
@NoArgsConstructor
public class UserQuestions implements Serializable {

    private Long questionId;

    private int bankQuestionID;

    private String answer;

    private Long userId;

    private String question;

}
