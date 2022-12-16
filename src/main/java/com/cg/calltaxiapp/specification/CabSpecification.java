package com.cg.calltaxiapp.specification;

import java.util.List;

import com.cg.calltaxiapp.entity.Cab;

public interface CabSpecification {

	public List<Cab> getRegisteredCabs();
	
	public List<Cab> getNewlyAddedCabs();
	
	public void saveCab(Cab cab);
	
	public void deleteCab(Cab cab);
}
