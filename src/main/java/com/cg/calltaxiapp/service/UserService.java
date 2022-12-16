package com.cg.calltaxiapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.calltaxiapp.entity.User;
import com.cg.calltaxiapp.exception.DuplicateValueException;
import com.cg.calltaxiapp.exception.InvalidLoginException;
import com.cg.calltaxiapp.exception.NoPersonFoundException;
import com.cg.calltaxiapp.repository.UserRepository;
import com.cg.calltaxiapp.specification.UserSpecification;

@Service
public class UserService implements UserSpecification{

	@Autowired
	UserRepository userRepository;

	public void saveUser(User user) {
		
		Optional<User> newuser = userRepository.findByEmail(user.getEmail());
		if(newuser.isPresent())
			throw new InvalidLoginException("Email-ID Exists", "user");
		
		newuser = userRepository.findByPhoneNumber(user.getPhoneNumber());
		if(newuser.isPresent())
		   throw new InvalidLoginException("Phone Exists", "user");
		
		user.setPassword(EncryptionDecryption.encryptPassword(user.getPassword()));	
	    userRepository.save(user);
	}

	public List<User> getAllUsers() {
		
		List<User> users = userRepository.findAll();
		if(users.isEmpty())
			throw new NoPersonFoundException("No users Found");
		
		return users; 
	}

	public User verfiyUserLogin(String email, String password) {
		
		Optional<User> user = userRepository.findByEmailAndPassword(email, EncryptionDecryption.encryptPassword(password));
		if(user.isPresent())
			return user.get();
	  throw new InvalidLoginException("Invalid Login", "user");       
	}

	public User getUserById(int id) {
		
		Optional<User> user = Optional.ofNullable(userRepository.getById(id));
		if(user.isPresent())
			return user.get();
	  throw new NoPersonFoundException("No person Found");
	}

}
