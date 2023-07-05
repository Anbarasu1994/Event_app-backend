package com.paramporul.foundation.model;

/*
 * @author sethuvekram
 * @date 24/02/2023
 */
public class Login {
	private String phoneNumber;
	private String uuid;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
