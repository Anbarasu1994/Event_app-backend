package com.paramporul.foundation.service;

import com.paramporul.foundation.dto.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.paramporul.foundation.model.User;
import com.paramporul.foundation.repository.UserRepository;

/*0

 * @author sethuvekram
 *  @date 24/02/2023
 */
@Service
public class LoginService {
	@Autowired
	private UserRepository userRepo;
	@Autowired(required = true)
	private LoginResponse response;

	public LoginResponse isLoginSuccessful(String phoneNumber, String uuid) {
		User user = userRepo.findByPhoneNumberAndUuid(phoneNumber, uuid);
		LoginResponse response = new LoginResponse();

		if (user != null && user.getPhoneNumber().equals(phoneNumber) && user.getUuid().equals(uuid)) {
			response.setUser(user);
			response.setMessage("Login Successful");
			return response;
		}
		response.setMessage("Login Failure");
		return response;
	}
}