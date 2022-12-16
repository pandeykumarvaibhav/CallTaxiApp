package com.cg.calltaxiapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.calltaxiapp.entity.Cab;

public interface CabRepository extends JpaRepository<Cab, Integer> {

	@Query("SELECT c FROM Cab c WHERE c.verify = 0")
	public List<Cab> getNewlyAddedCabs();

	@Query("SELECT c FROM Cab c where c.verify = 1")
	public List<Cab> getRegisteredCabs();

}
