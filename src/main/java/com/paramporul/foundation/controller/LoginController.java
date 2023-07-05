package com.paramporul.foundation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paramporul.foundation.dto.LoginResponse;
import com.paramporul.foundation.model.Login;
import com.paramporul.foundation.service.LoginService;
import com.paramporul.foundation.service.UserService;

/*
 * @author sethuvekram
 *  @date 24/02/2023
 */
@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private LoginService loginService;
	@Autowired
	private UserService userService;

	@PostMapping
	public LoginResponse login(@RequestBody Login login) {
		LoginResponse message = loginService.isLoginSuccessful(login.getPhoneNumber(), login.getUuid());
		return message;
	}
}
