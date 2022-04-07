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
@Table ( name ="HPPayment" )
public class HPPayment implements Serializable {

	private static final long serialVersionUID =  3033678374994878708L;

   	@Column(name = "HPPaymentID" )
	private Long hpPaymentId;

   	@Column(name = "Amount" )
	private Double amount;

	@JsonFormat(pattern = "yyyy-MM-dd")
   	@Column(name = "Date" )
	private Date date;

   	@Column(name = "HPID" )
	private Long hpId;

	public Long getHpPaymentId() {
		return this.hpPaymentId;
	}

	public void setHpPaymentId(Long hpPaymentId) {
		this.hpPaymentId = hpPaymentId;
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

	public Long getHpId() {
		return this.hpId;
	}

	public void setHpId(Long hpId) {
		this.hpId = hpId;
	}

}
