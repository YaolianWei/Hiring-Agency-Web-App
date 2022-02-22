package com.example.hiringagency.domain.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @Description  
 * @Author Yaolian
 * @Date 2022-02-06
 */

@Data
@NoArgsConstructor
@Table( name ="SecurityQuestions" )
public class SecurityQuestions  implements Serializable {

	private static final long serialVersionUID =  1294529902645851971L;

   	@Column(name = "QuestionID" )
	private Long questionId;

	@Column(name = "BankQuestionID" )
	private Long bankQuestionId;

   	@Column(name = "Answer" )
	private String answer;

  	@Column(name = "UserID" )
	private Long userId;

	public Long getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public Long getQuestion() {
		return this.bankQuestionId;
	}

	public void setQuestion(String question) {
		this.bankQuestionId = bankQuestionId;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
