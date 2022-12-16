package com.cg.calltaxiapp.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.calltaxiapp.dto.UserDto;
import com.cg.calltaxiapp.entity.Cab;
import com.cg.calltaxiapp.entity.Driver;
import com.cg.calltaxiapp.service.BookingService;
import com.cg.calltaxiapp.service.DriverService;
import com.cg.calltaxiapp.service.DriverStatusService;

@Controller
@RequestMapping("/driver")
public class DriverController {

	@Autowired
	DriverService driverService;

	@Autowired
	DriverStatusService driverStatusService;

	@Autowired
	BookingService bookingService;

	@RequestMapping("/register")
	public ModelAndView driverRegistration(@ModelAttribute Driver driver, @ModelAttribute Cab cab) {
		driver.setRegisteredDate(LocalDate.now());
		driver.setVerify(false);
		cab.setVerify(false);
		driver.setCab(cab);
		ModelAndView mav = new ModelAndView();
		driverService.saveDriver(driver);
		mav.setViewName("driver_registration_success");
		return mav;		
	}

	@RequestMapping("/registerform")
	public String driverRegistrationForm() {
		return "driver_registration";
	}

	@RequestMapping("/login")
	public String driverLogin() {
		return "driver_login";
	}

	@RequestMapping(value = "/loginvalidation")
	public ModelAndView loginValidation(@ModelAttribute UserDto driver) {
		ModelAndView mav = new ModelAndView();
		Driver validDriver = driverService.validateDriver(driver);
		mav.setViewName("driver_login_success");
		mav.addObject("status", driverStatusService.getDriverStatus(validDriver.getDriverID()));
		mav.addObject("driver", validDriver);
		return mav;
	}

	@RequestMapping("/newbooking")
	public ModelAndView newBooking(@RequestParam("driverid") int driverid) {
		ModelAndView mav = new ModelAndView();	
		mav.addObject("user", bookingService.getNewlyBookedUser(driverid));
		mav.addObject("driverid", driverid);
		mav.setViewName("new_user_booking");
		return mav;
	}

	@RequestMapping("/active")
	public ModelAndView activeDriver(@RequestParam("field") int driverid) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("driver", driverStatusService.makeDriverActive(driverid));
		mav.setViewName("driver_login_success");
		mav.addObject("status", true);
		return mav;
	}

	@RequestMapping("/inactive")
	public String inActiveDriver(@RequestParam("field") int driverid, @RequestParam("msg") String message) {
		driverStatusService.makeDriverInActive(driverid, message);
		return "driver_login";
	}

	@RequestMapping("/drivercancelbooking")
	public ModelAndView driverCancelBooking(@RequestParam("userid") int userid, @RequestParam("driverid") int driverid) {
		ModelAndView mav = new ModelAndView();
		bookingService.cancellBookingByDriver(userid);
		mav.addObject("driverid", driverid);
		mav.addObject("status", true);
		mav.addObject("driver", driverService.findDriverById(driverid));
		mav.setViewName("driver_login_success");
		return mav;
	}

	@RequestMapping("/driverstatus")
	public ModelAndView driverStatus() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("driverstatus", driverStatusService.getAllDriverStatus());
		mav.setViewName("driver_status");
		return mav;

	}
	
	@RequestMapping("/driversummary")
	public ModelAndView summary(@RequestParam("driverid") int driverid) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("driversummary");
	    mav.addObject("bookings", bookingService.findAllDriverById(driverid));
		return mav;
	}
}
