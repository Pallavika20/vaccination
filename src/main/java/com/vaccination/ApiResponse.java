package com.vaccination;

import org.springframework.stereotype.Component;

@Component
public class ApiResponse {
	private int responseCode;
	private String message;
	public int getResponseCode() {
		return this.responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getMessage() {
		return this.message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
