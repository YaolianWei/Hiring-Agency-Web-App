package com.example.hiringagency.domain.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

/**
 * @Description  
 * @Author Yaolian
 * @Date 2022-02-26 
 */

@Data
@NoArgsConstructor
@Table ( name ="ServiceEntries" )
public class ServiceEntries  implements Serializable {

	private static final long serialVersionUID =  8134917561381830569L;

   	@Column(name = "ServiceEntryID" )
	private Long serviceEntryId;

   	@Column(name = "Date" )
	private Date date;

   	@Column(name = "HPID" )
	private Long hpid;

   	@Column(name = "BillingID" )
	private Long billingId;

   	@Column(name = "StartTime" )
	private Date startTime;

   	@Column(name = "EndTime" )
	private Date endTime;

   	@Column(name = "CareRequestID" )
	private Long careRequestId;

	public Long getServiceEntryId() {
		return this.serviceEntryId;
	}

	public void setServiceEntryId(Long serviceEntryId) {
		this.serviceEntryId = serviceEntryId;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getHpid() {
		return this.hpid;
	}

	public void setHpid(Long hpid) {
		this.hpid = hpid;
	}

	public Long getBillingId() {
		return this.billingId;
	}

	public void setBillingId(Long billingId) {
		this.billingId = billingId;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Long getCareRequestId() {
		return this.careRequestId;
	}

	public void setCareRequestId(Long careRequestId) {
		this.careRequestId = careRequestId;
	}

}
