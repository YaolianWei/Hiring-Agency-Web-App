package com.example.hiringagency.domain.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
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

	@JsonFormat(pattern = "yyyy-MM-dd")
   	@Column(name = "Date" )
	private Date date;

   	@Column(name = "HPID" )
	private Long hpid;

   	@Column(name = "CompleteFlag" )
	private Boolean completeFlag;

	@JsonFormat(pattern = "HH:mm")
	@Column(name = "StartTime" )
	private Timestamp startTime;

	@JsonFormat(pattern = "HH:mm")
	@Column(name = "EndTime" )
	private Timestamp endTime;

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

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public Long getCareRequestId() {
		return this.careRequestId;
	}

	public void setCareRequestId(Long careRequestId) {
		this.careRequestId = careRequestId;
	}

}
