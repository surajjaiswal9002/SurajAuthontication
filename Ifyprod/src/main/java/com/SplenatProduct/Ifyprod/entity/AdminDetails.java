package com.SplenatProduct.Ifyprod.entity;

import lombok.Data;


@Data
public class AdminDetails {

	private String userName;
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
	private String password;
	@Override
	public String toString() {
		return "AdminDetails [userName=" + userName + ", password=" + password + "]";
	}
	public AdminDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminDetails(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	
	
	
	
}
