package com.cg.calltaxiapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.calltaxiapp.entity.Driver;

public interface DriverRepository extends JpaRepository<Driver, Integer> {

	@Query("SELECT d FROM Driver d WHERE d.verify = 0")
	public List<Driver> getNewlyAddedDrivers();

	@Query("SELECT d FROM Driver d WHERE d.verify = 1")
	public List<Driver> getRegisteredDrivers();
	
	public Optional<Driver> findByEmail(String email);
	public Optional<Driver> findByPhoneNumber(String phoneNumber);
	public Optional<Driver> findByLicenseNumber(String license);
	public Optional<Driver> findByAadharNumber(String aadhar);
	
	@Query("SELECT d from Driver d WHERE d.email = ?1 AND d.password = ?2")
	public Optional<Driver> findByEmailAndPassword(String email, String password);
}
