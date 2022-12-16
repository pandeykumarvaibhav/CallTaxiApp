package com.cg.calltaxiapp.specification;

import java.util.List;

import com.cg.calltaxiapp.entity.Booking;
import com.cg.calltaxiapp.entity.Driver;
import com.cg.calltaxiapp.entity.User;

public interface BookingSpecification {

	public void bookTheTicket(int driverId, int userId, String source, String destination);
	
	public User getNewlyBookedUser(int id);
	
	public void cancellBookingByDriver(int userid);
	
	public List<Booking> findAllCustomerById(int custid);
	
	public Driver getRegisteredDriverForBooking(int userid);
	
	public List<Booking> getAllBookings();
	
	public void cancelBookingByUser(int driverid);
	
	public List<Booking> checkIfDriverHasBooking(int id);
	
	public List<Booking> findAllDriverById(int driverid);
}
