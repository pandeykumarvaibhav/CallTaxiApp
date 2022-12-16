package com.cg.calltaxiapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.calltaxiapp.dto.UserDto;
import com.cg.calltaxiapp.entity.Cab;
import com.cg.calltaxiapp.entity.Driver;
import com.cg.calltaxiapp.exception.DuplicateValueException;
import com.cg.calltaxiapp.exception.InvalidLoginException;
import com.cg.calltaxiapp.exception.NoPersonFoundException;
import com.cg.calltaxiapp.repository.DriverRepository;
import com.cg.calltaxiapp.specification.DriverSpecification;

@Service
public class DriverService implements DriverSpecification{

	@Autowired
	DriverRepository driverRepo;

	@Autowired
	CabService cabService;

	@Autowired
	DriverStatusService driverStatusService;

	public void saveDriver(Driver driver) {

		Optional<Driver> newdriver = driverRepo.findByAadharNumber(driver.getAadharNumber());
		if(newdriver.isPresent())
			throw new InvalidLoginException("Aadhar Exists", "driver");

		newdriver = driverRepo.findByEmail(driver.getEmail());
		if(newdriver.isPresent())
			throw new InvalidLoginException("Email Exists", "driver");

		newdriver = driverRepo.findByPhoneNumber(driver.getPhoneNumber());
		if(newdriver.isPresent())
			throw new InvalidLoginException("Phone Exists", "driver");

		newdriver = driverRepo.findByLicenseNumber(driver.getLicenseNumber());
		if(newdriver.isPresent())
			throw new InvalidLoginException("License Exists", "driver");

		driver.setVerify(false);
		driver.setPassword(EncryptionDecryption.encryptPassword(driver.getPassword()));
		driverRepo.save(driver);
	}

	public List<Driver> getRegisteredDrivers() {

		List<Driver> drivers = driverRepo.getRegisteredDrivers();

		if(drivers.isEmpty())
			throw new NoPersonFoundException("No Drivers Registered Yet");
		return drivers;
	}

	public List<Driver> getNewlyAddedDrivers() {
		List<Driver> drivers = driverRepo.getNewlyAddedDrivers();

		if(drivers.isEmpty())
			throw new NoPersonFoundException("No New Drivers");
		return drivers;

	}

	public void approveDriver(int id) {

		Driver driver = driverRepo.findById(id).get();
		Cab cab = driver.getCab();
		driver.setVerify(true);
		cab.setVerify(true);

		driverRepo.save(driver);
		cabService.saveCab(cab);

		driverStatusService.addDriverAndCab(driver, cab);
	}

	public void deleteDriver(int id) {

		Driver driver = driverRepo.getById(id);
		Cab cab = driver.getCab();

		driverRepo.delete(driver);
		cabService.deleteCab(cab);
	}

	public Driver validateDriver(UserDto driver) {

		Optional<Driver> d = driverRepo.findByEmailAndPassword(driver.getEmail(), EncryptionDecryption.encryptPassword(driver.getPassword()));	
		if(d.isPresent()) {
			Driver d1 = d.get();
			if(d1.isVerify()) {
				System.out.println(EncryptionDecryption.decryptPassword(driver.getPassword()));
				return d1;
			}
		}
		throw new InvalidLoginException("Invalid Login", "driver");     
	}

	public Driver findDriverById(int id) {

		Optional<Driver> driver =driverRepo.findById(id);
		if(driver.isEmpty())
			throw new NoPersonFoundException("No person found");
		return driver.get();
	}
}
