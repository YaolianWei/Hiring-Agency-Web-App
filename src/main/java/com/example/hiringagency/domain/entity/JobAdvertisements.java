package com.example.hiringagency.domain.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description  
 * @Author Yaolian
 * @Date 2022-02-19 
 */

@Data
@NoArgsConstructor
@Table ( name ="JobAdvertisements" )
public class JobAdvertisements  implements Serializable {

	private static final long serialVersionUID =  2098774468618700528L;

   	@Column(name = "JobAdvertisementID" )
	private Long jobAdvertisementId;

   	@Column(name = "ServiceType" )
	private Long serviceType;

   	@Column(name = "EducationRequirement" )
	private Long educationRequirement;

   	@Column(name = "Experience" )
	private String experience;

	@Column(name = "Description" )
	private String description;

	public Long getJobAdvertisementId() {
		return this.jobAdvertisementId;
	}

	public void setJobAdvertisementId(Long jobAdvertisementId) {
		this.jobAdvertisementId = jobAdvertisementId;
	}

	public Long getServiceType() {
		return this.serviceType;
	}

	public void setServiceType(Long serviceType) {
		this.serviceType = serviceType;
	}

	public Long getEducationRequirement() {
		return this.educationRequirement;
	}

	public void setEducationRequirement(Long educationRequirement) {
		this.educationRequirement = educationRequirement;
	}

	public String getExperience() {
		return this.experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

}
