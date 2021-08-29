package com.vaccination;

import org.springframework.stereotype.Component;

@Component
public class RegistrationRequestDAO {
	private String userName;
	private int phoneNumber;
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return this.userName;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	

}
