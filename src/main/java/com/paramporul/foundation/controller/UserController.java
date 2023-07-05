package com.paramporul.foundation.controller;

import java.util.List;

import com.paramporul.foundation.dto.MessageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.paramporul.foundation.model.User;
import com.paramporul.foundation.service.UserService;

/*
 * @author sethuvekram
 * @date 23/02/2023
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
@RequiredArgsConstructor
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/addUser")
	public ResponseEntity<MessageResponse> addUser(@RequestBody User user) {
		return ResponseEntity.ok(userService.addUser(user));
	}

	@GetMapping("/getAllUserDetails")
	public List<User> getAllUser() {
		return userService.getAllUser();
	}

	@PutMapping("/updateUserDetails")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		return ResponseEntity.ok(userService.updateUser(user));
	}

	@DeleteMapping("/deleteUserDetails/{userId}")
	public String deleteById(@PathVariable int userId) {
		userService.deleteById(userId);
		return "user deleted";
	}

	@GetMapping("/getUserDetails/{uuid}")
	public User getUser(@PathVariable String uuid) {
		return userService.getUserByUuid(uuid);
	}

	@GetMapping("/getUserById/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable int userId) {
		return ResponseEntity.ok(userService.getUserById(userId));
	}
}
