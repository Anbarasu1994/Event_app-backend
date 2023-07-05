package com.paramporul.foundation.dto;

import com.paramporul.foundation.model.User;
import org.springframework.stereotype.Component;

@Component
public class LoginResponse {
	private String message;
	private User user;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
