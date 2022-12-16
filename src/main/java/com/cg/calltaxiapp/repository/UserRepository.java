package com.cg.calltaxiapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.calltaxiapp.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("SELECT u from User u WHERE u.email = ?1 AND u.password = ?2")
	public Optional<User> findByEmailAndPassword(String email, String password);
	
	public Optional<User> findByEmail(String email);
	
	public Optional<User> findByPhoneNumber(String phoneNumber);
}
