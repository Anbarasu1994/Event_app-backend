package com.paramporul.foundation.service;

import java.util.List;
import java.util.Optional;
import com.paramporul.foundation.dto.MessageResponse;
import com.paramporul.foundation.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.paramporul.foundation.model.User;
import com.paramporul.foundation.repository.UserRepository;

/*
 * @author sethuvekram
 *  @date 23/02/2023
 */
@Service
@RequiredArgsConstructor
public class UserService {
	@Autowired
	private UserRepository userRepo;

	public MessageResponse addUser(User user) {
		Optional<User> user1 = userRepo.findByPhoneNumber(user.getPhoneNumber());
		MessageResponse msg = new MessageResponse();
		if (user1.isPresent()) {
			msg.setMessage("SignUp Failure");
			return msg;
		}
		userRepo.save(user);
		msg.setMessage("Signed Up Successfully");
		msg.setUser(user);
		return msg;
	}

	public List<User> getAllUser() {
		return userRepo.findAll();
	}

	public User updateUser(User user) {
		return userRepo.save(user);
	}

	public void deleteById(int userId) {
		userRepo.deleteById(userId);
	}

	public User getUserByUuid(String uuid) {
		return userRepo.findByUuid(uuid);
	}

	public User getUserById(int userId) {
		return (User) userRepo.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
	}
}
