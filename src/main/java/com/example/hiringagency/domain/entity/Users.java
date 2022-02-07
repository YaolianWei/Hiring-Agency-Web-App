package com.example.hiringagency.domain.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description  
 * @Author Yaolian
 * @Date 2022-02-07 
 */

@Data
@NoArgsConstructor
@Table ( name ="Users" )
public class Users  implements Serializable {

	private static final long serialVersionUID =  6541199138585318327L;

   	@Column(name = "UserID" )
	private Long userId;

   	@Column(name = "FirstName" )
	private String firstName;

   	@Column(name = "LastName" )
	private String lastName;

   	@Column(name = "Username" )
	private String username;

   	@Column(name = "Password" )
	private String password;

   	@Column(name = "FirstLogin" )
	private Boolean firstLogin;

   	@Column(name = "PostalAddress" )
	private String postalAddress;

   	@Column(name = "PhoneNumber" )
	private Long phoneNumber;

   	@Column(name = "Email" )
	private String email;

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getFirstLogin() {
		return this.firstLogin;
	}

	public void setFirstLogin(Boolean firstLogin) {
		this.firstLogin = firstLogin;
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

}
