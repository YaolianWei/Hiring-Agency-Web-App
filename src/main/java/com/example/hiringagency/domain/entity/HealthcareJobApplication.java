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
 * @Date 2022-02-19 
 */

@Data
@NoArgsConstructor
@Table ( name ="HealthcareJobApplication" )
public class HealthcareJobApplication  implements Serializable {

	private static final long serialVersionUID =  714638034208707832L;

   	@Column(name = "HealthcareJobApplicationID" )
	private Long healthcareJobApplicationId;

   	@Column(name = "FirstName" )
	private String firstName;

   	@Column(name = "LastName" )
	private String lastName;

   	@Column(name = "Gender" )
	private Long gender;

   	@Column(name = "DateOfBirth" )
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;

   	@Column(name = "SSN" )
	private String ssn;

   	@Column(name = "ServiceType" )
	private Long serviceType;

	@Column(name = "Degree" )
	private Long degree;

   	@Column(name = "EducationQualifications" )
	private String educationQualifications;

   	@Column(name = "YearsExperience" )
	private Long yearsExperience;

   	@Column(name = "PostalAddress" )
	private String postalAddress;

   	@Column(name = "PhoneNumber" )
	private Long phoneNumber;

   	@Column(name = "Email" )
	private String email;

   	@Column(name = "Active" )
	private Boolean active;

   	@Column(name = "UserID" )
	private Long userId;

	@Column(name = "JobAdvertisementId" )
	private Long jobAdvertisementId;

	public Long getHealthcareJobApplicationId() {
		return this.healthcareJobApplicationId;
	}

	public void setHealthcareJobApplicationId(Long healthcareJobApplicationId) {
		this.healthcareJobApplicationId = healthcareJobApplicationId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getGender() {
		return this.gender;
	}

	public void setGender(Long gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getSsn() {
		return this.ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public Long getServiceType() {
		return this.serviceType;
	}

	public void setServiceType(Long serviceType) {
		this.serviceType = serviceType;
	}

	public String getEducationQualifications() {
		return this.educationQualifications;
	}

	public void setEducationQualifications(String educationQualifications) {
		this.educationQualifications = educationQualifications;
	}

	public Long getYearsExperience() {
		return this.yearsExperience;
	}

	public void setYearsExperience(Long yearsExperience) {
		this.yearsExperience = yearsExperience;
	}

	public String getPostalAddress() {
		return this.postalAddress;
	}

	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}

	public Long getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
