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
@Table ( name ="Service" )
public class CareService implements Serializable {

	private static final long serialVersionUID =  2661740745149385858L;

   	@Column(name = "ServiceID" )
	private Long serviceId;

   	@Column(name = "RequestID" )
	private Long requestId;

   	@Column(name = "HPID" )
	private Long hpid;

   	@Column(name = "CareTakerID" )
	private Long careTakerId;

   	@Column(name = "Status" )
	private Long status;

	public Long getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}

	public Long getRequestId() {
		return this.requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public Long getHpid() {
		return this.hpid;
	}

	public void setHpid(Long hpid) {
		this.hpid = hpid;
	}

	public Long getCareTakerId() {
		return this.careTakerId;
	}

	public void setCareTakerId(Long careTakerId) {
		this.careTakerId = careTakerId;
	}

	public Long getStatus() {
		return this.status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

}
