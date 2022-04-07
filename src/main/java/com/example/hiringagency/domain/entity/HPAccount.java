package com.example.hiringagency.domain.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description  
 * @Author Yaolian
 * @Date 2022-04-05 
 */

@Data
@NoArgsConstructor
@Table ( name ="HPAccount" )
public class HPAccount implements Serializable {

	private static final long serialVersionUID =  8320104906202165671L;

   	@Column(name = "HPAccountID" )
	private Long hpAccountId;

   	@Column(name = "AmountPaid" )
	private Double amountPaid;

   	@Column(name = "AmountYetToPay" )
	private Double amountYetToPay;

   	@Column(name = "HPID" )
	private Long hpId;

	public Long getHpAccountId() {
		return this.hpAccountId;
	}

	public void setHpAccountId(Long hpAccountId) {
		this.hpAccountId = hpAccountId;
	}

	public Double getAmountPaid() {
		return this.amountPaid;
	}

	public void setAmountPaid(Double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public Double getAmountYetToPay() {
		return this.amountYetToPay;
	}

	public void setAmountYetToPay(Double amountYetToPay) {
		this.amountYetToPay = amountYetToPay;
	}

	public Long getHpId() {
		return this.hpId;
	}

	public void setHpId(Long hpId) {
		this.hpId = hpId;
	}

}
