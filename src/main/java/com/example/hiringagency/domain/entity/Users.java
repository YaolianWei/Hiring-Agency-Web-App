package com.example.hiringagency.domain.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description  
 * @Author Yaolian
 * @Date 2022-02-06 
 */

@Data
@NoArgsConstructor
@Table ( name ="Users" )
public class Users  implements Serializable {

	private static final long serialVersionUID =  3181338348511001349L;

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

}
