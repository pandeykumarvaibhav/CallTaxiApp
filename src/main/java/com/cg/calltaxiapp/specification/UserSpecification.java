package com.cg.calltaxiapp.specification;

import java.util.List;
import com.cg.calltaxiapp.entity.User;
import com.cg.calltaxiapp.exception.DuplicateValueException;
import com.cg.calltaxiapp.exception.NoPersonFoundException;
import com.cg.calltaxiapp.exception.InvalidLoginException;

public interface UserSpecification {

	public void saveUser(User user)throws DuplicateValueException;
	
	public List<User> getAllUsers();
	
	public User verfiyUserLogin(String email, String password)throws InvalidLoginException;
	
	public User getUserById(int id)throws NoPersonFoundException;

}
