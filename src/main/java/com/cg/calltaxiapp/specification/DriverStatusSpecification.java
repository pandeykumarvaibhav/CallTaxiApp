package com.cg.calltaxiapp.specification;

import java.util.List;

import com.cg.calltaxiapp.entity.Cab;
import com.cg.calltaxiapp.entity.Driver;
import com.cg.calltaxiapp.entity.DriverStatus;
import com.cg.calltaxiapp.exception.InvalidStateException;

public interface DriverStatusSpecification {

	public void addDriverAndCab(Driver driver, Cab cab);
	
	public List<Driver> getFreeDrivers();
	
	public List<Cab> getFreeCabs();
	
	public boolean getDriverStatus(int id);
	
	public Driver makeDriverActive(int id);
	
	public void makeDriverInActive(int id, String message)throws InvalidStateException;
	
	public void makeDriverOnservice(int id);
	
	public List<DriverStatus> getAllDriverStatus();
	
}
