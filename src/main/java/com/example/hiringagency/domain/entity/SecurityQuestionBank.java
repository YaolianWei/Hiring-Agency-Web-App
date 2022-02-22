package com.example.hiringagency.domain.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @Description  
 * @Author Yaolian
 * @Date 2022-02-07 
 */

@Data
@NoArgsConstructor
@Table( name ="SecurityQuestionBank" )
public class SecurityQuestionBank  implements Serializable {

	private static final long serialVersionUID =  4734588478222814739L;

   	@Column(name = "BankQuestionID" )
	private Long bankQuestionId;

   	@Column(name = "Question" )
	private String question;

	public Long getBankQuestionId() {
		return this.bankQuestionId;
	}

	public void setBankQuestionId(Long bankQuestionId) {
		this.bankQuestionId = bankQuestionId;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

}
