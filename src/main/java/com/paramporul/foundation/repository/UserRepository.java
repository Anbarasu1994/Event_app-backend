package com.paramporul.foundation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.paramporul.foundation.model.User;

/*
 * @author sethuvekram
 * @date 23/02/2023
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	public Optional<User> findByPhoneNumber(String phoneNumber);
	public User findByPhoneNumberAndUuid(String phoneNumber, String uuid);
	public User findByUuid(String uuid);
}
