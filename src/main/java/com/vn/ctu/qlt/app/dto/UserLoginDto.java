package com.vn.ctu.qlt.app.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * @author NTDSIVAL
 * @Date Dec 27, 2018
 */

public class UserLoginDto implements Serializable {

	private static final long serialVersionUID = -1581714007513597656L;

	@NotNull
	private String userName;
	
	@NotNull
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
