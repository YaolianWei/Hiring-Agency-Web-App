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
@Table ( name ="CareTakerRegistration" )
public class CareTakerRegistration  implements Serializable {

	private static final long serialVersionUID =  8027272259280248150L;

   	@Column(name = "CareTakerRegistrationID" )
	private Long careTakerRegistrationId;

   	@Column(name = "FirstName" )
	private String firstName;

   	@Column(name = "LastName" )
	private String lastName;

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

	public Long getCareTakerRegistrationId() {
		return this.careTakerRegistrationId;
	}

	public void setCareTakerRegistrationId(Long careTakerRegistrationId) {
		this.careTakerRegistrationId = careTakerRegistrationId;
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

	public Long getuserId() {
		return this.userId;
	}

	public void setuserId(Long userId) {
		this.userId = userId;
	}

}
