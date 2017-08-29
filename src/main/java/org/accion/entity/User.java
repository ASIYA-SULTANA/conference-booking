package org.accion.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	@Column(name="USERNAME")
	String userName;
	
	@Column(name="FULLNAME")
	String fullName;
	
	@Column(name="PASSWORD")
	String password;
	
	@Column(name="EMAILID")
	String emailId;

	public String getUserName() {
		return userName;
	}
	@ManyToOne(cascade = CascadeType.ALL)
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	

}
