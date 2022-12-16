package com.cg.calltaxiapp.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.calltaxiapp.dto.BookingDto;
import com.cg.calltaxiapp.dto.UserDto;
import com.cg.calltaxiapp.entity.User;
import com.cg.calltaxiapp.service.BookingService;
import com.cg.calltaxiapp.service.DriverService;
import com.cg.calltaxiapp.service.DriverStatusService;
import com.cg.calltaxiapp.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	DriverStatusService driverStatusService;

	@Autowired
	DriverService driverService;

	@Autowired
	BookingService bookingService;

	@RequestMapping("/login")
	public String userLogin() {
		return "userlogin";
	}

	@RequestMapping("/register")
	public String userRegister() {
		return "user_registration";
	}

	@PostMapping("/saveuser")
	public String valid(@ModelAttribute User user) {
		user.setRegisteredDate(LocalDate.now());
		 userService.saveUser(user);
		return "user_registration_success";
	}

	@RequestMapping(value = "/verifyuser")
	public ModelAndView verifyUser(@ModelAttribute UserDto userdto) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user_validation_success");
		mav.addObject("user",  userService.verfiyUserLogin(userdto.getEmail(), userdto.getPassword()));
		return mav;	
	}

	@RequestMapping("/booking")
	public ModelAndView booking(@RequestParam("userid") int userid) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("booking");
		mav.addObject("drivers", driverStatusService.getFreeDrivers());
		mav.addObject("cabs", driverStatusService.getFreeCabs());
		mav.addObject("userid", userid);
		return mav;
	}

	@RequestMapping("/book")
	public ModelAndView bookACar(@ModelAttribute BookingDto bookingDto) {
		driverStatusService.makeDriverOnservice(bookingDto.getDriverId());
		bookingService.bookTheTicket(bookingDto.getDriverId(),
				bookingDto.getUserId(),
				bookingDto.getSource(),
				bookingDto.getDestination());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("taxi_booked");
		mav.addObject("driver", driverService.findDriverById(bookingDto.getDriverId()));
		return mav;
	}

	@RequestMapping("/mybooking")
	public ModelAndView myBookings(@RequestParam("userid") int userid) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mybooking");
		mav.addObject("bookings", bookingService.getAllTicketStatusOfParticularUser(userid));
		mav.addObject("userid", userid);
		return mav;
	}

	@RequestMapping("/usercancelbooking")
	public ModelAndView userCancelBooking(@RequestParam("driverid") int driverid, @RequestParam("userid") int userid) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mybooking");
		bookingService.cancelBookingByUser(driverid);
		mav.setViewName("mybooking");
		mav.addObject("bookings", bookingService.getAllTicketStatusOfParticularUser(driverid));
		mav.addObject("userid", userid);
		return mav;
	}
}
