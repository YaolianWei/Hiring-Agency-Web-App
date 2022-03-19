package com.example.hiringagency.domain.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description  
 * @Author Yaolian
 * @Date 2022-02-26 
 */

@Data
@NoArgsConstructor
@Table ( name ="Billing" )
public class Billing  implements Serializable {

	private static final long serialVersionUID =  8917345549048495086L;

   	@Column(name = "BillingID" )
	private Long billingId;

   	@Column(name = "CareTakerID" )
	private Long careTakerId;

   	@Column(name = "CareRequestID" )
	private Long careRequestId;

   	@Column(name = "HourlyRate" )
	private Double hourlyRate;

   	@Column(name = "PaidAmount" )
	private Double paidAmount;

   	@Column(name = "AmountYetToPay" )
	private Double amountYetToPay;

	public Long getBillingId() {
		return this.billingId;
	}

	public void setBillingId(Long billingId) {
		this.billingId = billingId;
	}

	public Long getCareTakerId() {
		return this.careTakerId;
	}

	public void setCareTakerId(Long careTakerId) {
		this.careTakerId = careTakerId;
	}

	public Long getCareRequestId() {
		return this.careRequestId;
	}

	public void setCareRequestId(Long careRequestId) {
		this.careRequestId = careRequestId;
	}

	public Double getHourlyRate() {
		return this.hourlyRate;
	}

	public void setHourlyRate(Double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public Double getPaidAmount() {
		return this.paidAmount;
	}

	public void setPaidAmount(Double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public Double getAmountYetToPay() {
		return this.amountYetToPay;
	}

	public void setAmountYetToPay(Double amountYetToPay) {
		this.amountYetToPay = amountYetToPay;
	}
}
