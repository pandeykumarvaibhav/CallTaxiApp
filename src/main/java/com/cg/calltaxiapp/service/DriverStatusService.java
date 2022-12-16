package com.cg.calltaxiapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.calltaxiapp.entity.Booking;
import com.cg.calltaxiapp.entity.Cab;
import com.cg.calltaxiapp.entity.Driver;
import com.cg.calltaxiapp.entity.DriverStatus;
import com.cg.calltaxiapp.exception.InvalidStateException;
import com.cg.calltaxiapp.exception.NoPersonFoundException;
import com.cg.calltaxiapp.repository.DriverStatusRepository;
import com.cg.calltaxiapp.specification.DriverStatusSpecification;

@Service
public class DriverStatusService implements DriverStatusSpecification{

	@Autowired
	DriverStatusRepository driverStatusRepository;

	@Autowired
	BookingService bookingService;
	
	public void addDriverAndCab(Driver driver, Cab cab) {

		DriverStatus ds = new DriverStatus();
		ds.setId(driver.getDriverID());
		ds.setOnSerivce(false);
		ds.setActive(false);
		ds.setCab(cab);
		ds.setDriver(driver);

		driverStatusRepository.save(ds);
	}

	public List<Driver> getFreeDrivers() {

		List<Driver> drivers = new ArrayList<>();
		for (DriverStatus dstatus : driverStatusRepository.findAll())
			if (dstatus.getActive() && !dstatus.getOnSerivce())
				drivers.add(dstatus.getDriver());
        
		return drivers;
	}

	public List<Cab> getFreeCabs() {
		List<Cab> cabs = new ArrayList<>();

		for (Driver driver : getFreeDrivers())
			cabs.add(driver.getCab());
		return cabs;

	}

	public boolean getDriverStatus(int id) {

		return driverStatusRepository.findById(id).get().getActive();
	}

	public Driver makeDriverActive(int id) {

		Optional<DriverStatus> ds = driverStatusRepository.findById(id);
		if(ds.isEmpty())
			throw new NoPersonFoundException("No Driver Found with ID : "+id);
		
		ds.get().setActive(true);
		driverStatusRepository.save(ds.get());
		return ds.get().getDriver();
	}

	public void makeDriverInActive(int driverid, String message) {

		Optional<DriverStatus> ds = driverStatusRepository.findById(driverid);
		
		if(ds.isPresent()) {			
		List<Booking> bookings = bookingService.checkIfDriverHasBooking(driverid);
		
		if(!bookings.isEmpty())
		throw new InvalidStateException(bookings.get(0).getUser(), message);
		
		ds.get().setActive(false);
		ds.get().setOnSerivce(false);
		driverStatusRepository.save(ds.get());
		}
		else
		throw new NoPersonFoundException("No Driver with such ID : "+driverid);
	}

	public void makeDriverOnservice(int id) {

		Optional<DriverStatus> ds = driverStatusRepository.findById(id);
		
		if(ds.isEmpty())
			throw new NoPersonFoundException("No Driver Found with ID : "+id);
		ds.get().setOnSerivce(true);
		driverStatusRepository.save(ds.get());
	}

	public void makeDriverFreeOnservice(int id) {

		Optional<DriverStatus> ds = driverStatusRepository.findById(id);
		
		if(ds.isEmpty())
		throw new NoPersonFoundException("No Driver Found with ID : "+id);
		ds.get().setOnSerivce(false);
		driverStatusRepository.save(ds.get());
	}

	public List<DriverStatus> getAllDriverStatus() {
		return driverStatusRepository.findAll();
	}

}
