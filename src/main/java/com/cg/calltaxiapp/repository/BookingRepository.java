package com.cg.calltaxiapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.calltaxiapp.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

	@Query("SELECT b FROM Booking b WHERE driver_id = ?1 AND status = 'b' ORDER BY bookingID DESC")
	public List<Booking> findNewlyBookedCustomer(int driverId);

	@Query("SELECT b FROM Booking b WHERE cust_id = ?1 AND status = 'b' ORDER BY bookingID DESC")
	public List<Booking> cancelledBookingByDriver(int custId);

	@Query("SELECT b FROM Booking b WHERE cust_id = ?1 AND status = 'c' ORDER BY bookingID DESC")
	public List<Booking> getBookingIdForCancelledTicketForUser(int custid);

	@Query("SELECT b FROM Booking b WHERE cust_id = ?1 AND status = 'b' ORDER BY bookingID DESC")
	public List<Booking> findDriverForAppropriateUser(int custid);

	@Query("SELECT b FROM Booking b WHERE cust_id = ?1 ORDER BY bookingID DESC")
	public List<Booking> findAllCustomerById(int custid);
	
	@Query("SELECT b FROM Booking b WHERE driver_id = ?1 ORDER BY bookingID DESC")
	public List<Booking> findAllDriverById(int driverid);
	
	@Query("SELECT b FROM Booking b WHERE driver_id = ?1 AND status = 'b' ")
	public List<Booking> checkIfDriverHasBooking(int driverid);
}
