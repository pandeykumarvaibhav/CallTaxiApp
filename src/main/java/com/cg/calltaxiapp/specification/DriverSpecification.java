package com.cg.calltaxiapp.specification;

import java.util.List;

import com.cg.calltaxiapp.dto.UserDto;
import com.cg.calltaxiapp.entity.Driver;
import com.cg.calltaxiapp.exception.DuplicateValueException;
import com.cg.calltaxiapp.exception.InvalidLoginException;

public interface DriverSpecification {

	public void saveDriver(Driver driver)throws DuplicateValueException;
	
	public List<Driver> getRegisteredDrivers();
	
	public List<Driver> getNewlyAddedDrivers();
	
	public void approveDriver(int id);
	
	public void deleteDriver(int id);
	
	public Driver validateDriver(UserDto driver)throws InvalidLoginException;
	
	public Driver findDriverById(int id);
}
