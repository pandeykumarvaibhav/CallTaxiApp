package com.cg.calltaxiapp.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.calltaxiapp.entity.Booking;
import com.cg.calltaxiapp.entity.Driver;
import com.cg.calltaxiapp.entity.User;
import com.cg.calltaxiapp.exception.NoPersonFoundException;
import com.cg.calltaxiapp.repository.BookingRepository;
import com.cg.calltaxiapp.specification.BookingSpecification;

@Service
public class BookingService implements BookingSpecification{

	@Autowired
	BookingRepository bookingRepo;

	@Autowired
	DriverService driverService;

	@Autowired
	UserService userService;

	@Autowired
	DriverStatusService driverStatusService;

	public void bookTheTicket(int driverId, int userId, String source, String destination) {
		Booking booking = new Booking();
		booking.setBookedTimestamp(LocalDateTime.now());
		booking.setSource(source);
		booking.setDestination(destination);
		booking.setDriver(driverService.findDriverById(driverId));
		booking.setUser(userService.getUserById(userId));
		booking.setStatus('b');
		booking.setAmount(DistanceCalculator.calculateDistance(source, destination));
		bookingRepo.save(booking);
	}

	public User getNewlyBookedUser(int driverid) {

		List<Booking> bookings = bookingRepo.findNewlyBookedCustomer(driverid);
		if (bookings.isEmpty())		
			throw new NoPersonFoundException("No Bookings Found");
		return bookings.get(0).getUser();
	}

	public void cancellBookingByDriver(int userid) {

		List<Booking> booking = bookingRepo.cancelledBookingByDriver(userid);

		booking.get(0).setStatus('c');
		booking.get(0).setAmount(0);
		bookingRepo.save(booking.get(0));
		driverStatusService.makeDriverFreeOnservice(booking.get(0).getDriver().getDriverID());
	}

	public List<Booking> getAllTicketStatusOfParticularUser(int userid) {
		
		List<Booking> bookings = bookingRepo.findAllCustomerById(userid);
		if(bookings.isEmpty())
			throw new NoPersonFoundException("No Booking has been made");
		return bookings;
	}

	public List<Booking> findAllCustomerById(int custid) {
		
		List<Booking> bookings = bookingRepo.findAllCustomerById(custid);
		if(bookings.isEmpty())
			throw new NoPersonFoundException("No Users Found");
		return bookings;
		
	}

	public Driver getRegisteredDriverForBooking(int userid) {

		List<Booking> bookings = bookingRepo.findDriverForAppropriateUser(userid);
		if (!bookings.isEmpty())
			return bookings.get(0).getDriver();
		return null;
	}

	public List<Booking> getAllBookings() {
		
		List<Booking> bookings = bookingRepo.findAll();
	    if(bookings.isEmpty())
	    	throw new NoPersonFoundException("No Booking has been made yet");
		return bookings;
	}
	public void cancelBookingByUser(int driverid) {
		List<Booking> bookings = bookingRepo.findNewlyBookedCustomer(driverid);
		driverStatusService.makeDriverFreeOnservice(driverid);
		if (bookings.isEmpty())
			return;
		bookings.get(0).setStatus('c');
		bookings.get(0).setAmount(0);
		bookingRepo.save(bookings.get(0));
	}
	
	public List<Booking> checkIfDriverHasBooking(int driverid){
		return bookingRepo.checkIfDriverHasBooking(driverid);
	}
	
	public List<Booking> findAllDriverById(int driverid){
		List<Booking> bookings = bookingRepo.findAllDriverById(driverid);
		if(bookings.isEmpty())
			throw new NoPersonFoundException("No Bookings has been made yet");
		return bookings;
	}
}
