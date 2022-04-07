package com.example.hiringagency.domain.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

/**
 * @Description  
 * @Author Yaolian
 * @Date 2022-04-05 
 */

@Data
@NoArgsConstructor
@Table ( name ="CTPayment" )
public class CTPayment implements Serializable {

	private static final long serialVersionUID =  6808622812890947226L;

   	@Column(name = "CTPaymentID" )
	private Long ctPaymentId;

   	@Column(name = "Amount" )
	private Double amount;

	@JsonFormat(pattern = "yyyy-MM-dd")
   	@Column(name = "Date" )
	private Date date;

   	@Column(name = "BillingID" )
	private Long billingId;

	public Long getCtPaymentId() {
		return this.ctPaymentId;
	}

	public void setCtPaymentId(Long ctPaymentId) {
		this.ctPaymentId = ctPaymentId;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getBillingId() {
		return this.billingId;
	}

	public void setBillingId(Long billingId) {
		this.billingId = billingId;
	}

}
