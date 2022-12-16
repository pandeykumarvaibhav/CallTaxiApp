package com.cg.calltaxiapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.calltaxiapp.entity.Driver;
import com.cg.calltaxiapp.entity.DriverStatus;

public interface DriverStatusRepository extends JpaRepository<DriverStatus, Integer> {

	@Query("SELECT d FROM Driver d JOIN DriverStatus ds ON d.driverID = ("
			+ "SELECT ds from DriverStatus ds WHERE ds.active = 1)")
	public List<Driver> getFreeDrivers();
	
}
