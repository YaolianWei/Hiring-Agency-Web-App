package com.example.hiringagency.domain.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description  
 * @Author Yaolian
 * @Date 2022-02-07 
 */

@Data
@NoArgsConstructor
@Table ( name ="SecurityQuestions" )
public class SecurityQuestions  implements Serializable {

	private static final long serialVersionUID =  5685392052734455560L;

   	@Column(name = "QuestionID" )
	private Long QuestionID;

   	@Column(name = "Question" )
	private String Question;

   	@Column(name = "Answer" )
	private String Answer;

   	@Column(name = "UserID" )
	private Long UserID;

	public Long getQuestionId() {
		return this.QuestionID;
	}

	public void setQuestionId(Long questionId) {
		this.QuestionID = questionId;
	}

	public String getQuestion() {
		return this.Question;
	}

	public void setQuestion(String question) {
		this.Question = question;
	}

	public String getAnswer() {
		return this.Answer;
	}

	public void setAnswer(String answer) {
		this.Answer = answer;
	}

	public Long getUserID() {
		return this.UserID;
	}

	public void setUserID(Long userID) {
		this.UserID = userID;
	}

}
