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
@Table ( name ="CareRequests" )
public class CareRequests  implements Serializable {

	private static final long serialVersionUID =  4666251614556064243L;

   	@Column(name = "CareRequestID" )
	private Long careRequestId;

   	@Column(name = "FirstName" )
	private String firstName;

   	@Column(name = "LastName" )
	private String lastName;

   	@Column(name = "Gender" )
	private Long gender;

	@JsonFormat(pattern = "yyyy-MM-dd")
   	@Column(name = "DateOfBirth" )
	private Date dateOfBirth;

   	@Column(name = "ServiceAddress" )
	private String serviceAddress;

   	@Column(name = "PatientPhone" )
	private Long patientPhone;

   	@Column(name = "PatientEmail" )
	private String patientEmail;

   	@Column(name = "WeekDay")
	private String weekDay;

	@JsonFormat(pattern = "HH:mm")
   	@Column(name = "StartTime" )
	private Timestamp startTime;

	@JsonFormat(pattern = "HH:mm")
   	@Column(name = "EndTime" )
	private Timestamp endTime;

   	@Column(name = "TotalDays" )
	private Long totalDays;

   	@Column(name = "GenderSpecific" )
	private Long genderSpecific;

   	@Column(name = "LowerAgeLimit" )
	private Long lowerAgeLimit;

   	@Column(name = "UpperAgeLimit" )
	private Long upperAgeLimit;

   	@Column(name = "FlexibleHoursFlag" )
	private Boolean flexibleHoursFlag;

   	@Column(name = "FlexibleHoursPerDay" )
	private Long flexibleHoursPerDay;

   	@Column(name = "CareTakerID" )
	private Long careTakerId;

   	@Column(name = "ServiceType" )
	private Long serviceType;

	public Long getCareRequestId() {
		return this.careRequestId;
	}

	public void setCareRequestId(Long careRequestId) {
		this.careRequestId = careRequestId;
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

	public String getServiceAddress() {
		return this.serviceAddress;
	}

	public void setServiceAddress(String serviceAddress) {
		this.serviceAddress = serviceAddress;
	}

	public Long getPatientPhone() {
		return this.patientPhone;
	}

	public void setPatientPhone(Long patientPhone) {
		this.patientPhone = patientPhone;
	}

	public String getPatientEmail() {
		return this.patientEmail;
	}

	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}

	public void setWeekDay(String weekDay){
		this.weekDay = weekDay;
	}

	public String getWeekDay(){
		return this.weekDay;
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

	public Long getTotalDays() {
		return this.totalDays;
	}

	public void setTotalDays(Long totalDays) {
		this.totalDays = totalDays;
	}

	public Long getGenderSpecific() {
		return this.genderSpecific;
	}

	public void setGenderSpecific(Long genderSpecific) {
		this.genderSpecific = genderSpecific;
	}

	public Long getLowerAgeLimit() {
		return this.lowerAgeLimit;
	}

	public void setLowerAgeLimit(Long lowerAgeLimit) {
		this.lowerAgeLimit = lowerAgeLimit;
	}

	public Long getUpperAgeLimit() {
		return this.upperAgeLimit;
	}

	public void setUpperAgeLimit(Long upperAgeLimit) {
		this.upperAgeLimit = upperAgeLimit;
	}

	public Boolean getFlexibleHoursFlag() {
		return this.flexibleHoursFlag;
	}

	public void setFlexibleHoursFlag(Boolean flexibleHoursFlag) {
		this.flexibleHoursFlag = flexibleHoursFlag;
	}

	public Long getFlexibleHoursPerDay() {
		return this.flexibleHoursPerDay;
	}

	public void setFlexibleHoursPerDay(Long flexibleHoursPerDay) {
		this.flexibleHoursPerDay = flexibleHoursPerDay;
	}

	public Long getCareTakerId() {
		return this.careTakerId;
	}

	public void setCareTakerId(Long careTakerId) {
		this.careTakerId = careTakerId;
	}

	public Long getServiceType() {
		return this.serviceType;
	}

	public void setServiceType(Long serviceType) {
		this.serviceType = serviceType;
	}

}
