package com.cg.calltaxiapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.calltaxiapp.entity.Cab;
import com.cg.calltaxiapp.exception.NoPersonFoundException;
import com.cg.calltaxiapp.repository.CabRepository;
import com.cg.calltaxiapp.specification.CabSpecification;

@Service
public class CabService implements CabSpecification{

	@Autowired
	CabRepository cabRepo;

	public List<Cab> getRegisteredCabs() {
		
		List<Cab> cabs = cabRepo.getRegisteredCabs();
		if(cabs.isEmpty())
			throw new NoPersonFoundException("No Registered cabs ");
		return cabs;
	}

	public List<Cab> getNewlyAddedCabs() {
		
		List<Cab> cabs = cabRepo.getNewlyAddedCabs();
		if(cabs.isEmpty())
			throw new NoPersonFoundException("No New cabs ");
		return cabs;
	
	}

	public void saveCab(Cab cab) {
		cabRepo.save(cab);
	}

	public void deleteCab(Cab cab) {
		cabRepo.delete(cab);
	}
}
