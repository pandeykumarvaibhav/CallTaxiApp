package com.cg.calltaxiapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.calltaxiapp.entity.Admin;
import com.cg.calltaxiapp.service.AdminService;
import com.cg.calltaxiapp.service.BookingService;
import com.cg.calltaxiapp.service.CabService;
import com.cg.calltaxiapp.service.DriverService;
import com.cg.calltaxiapp.service.UserService;

@Controller
public class MainController {

	@Autowired
	AdminService adminService;

	@Autowired
	UserService userService;

	@Autowired
	DriverService driverService;

	@Autowired
	CabService cabService;

	@Autowired
	BookingService bookingService;

	@RequestMapping("/home")
	public String homePage() {
		return "home";
	}

	@RequestMapping("/admin")
	public String admin() {
		return "admin_login";
	}

	@RequestMapping(value = "/verifyadmin")
	public String verifyAdmin(@ModelAttribute Admin admin) {

		adminService.verifyAdmin(admin);
		return "admin_success";
	}

	@RequestMapping(value = "/verifiedadmin")
	public String successAdmin() {
		return "admin_success";
	}

	@RequestMapping(value = "/registereduser")
	public ModelAndView registeredUser() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("registered_user");
		mav.addObject("users", userService.getAllUsers());
		return mav;
	}

	@RequestMapping("/driver")
	public String driver() {
		return "driver_home";
	}

	@RequestMapping("/registereddriver")
	public ModelAndView getDrivers() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("registered_driver");
		mav.addObject("drivers", driverService.getRegisteredDrivers());
		mav.addObject("cabs",  cabService.getRegisteredCabs());
		return mav;
	}

	@RequestMapping("/cabs")
	public ModelAndView cabs() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("cab_details");
		mav.addObject("cabs", cabService.getRegisteredCabs());
		return mav;
	}

	@RequestMapping("/newdriver")
	public ModelAndView newDrivers() {
		return helperForRegisteredDrivers();

	}

	@RequestMapping("/approvedriver")
	public ModelAndView approveDriver(@RequestParam("id") int id) {
		driverService.approveDriver(id);
		return helperForRegisteredDrivers();
	}

	@RequestMapping("/rejectdriver")
	public ModelAndView rejectDriver(@RequestParam("id") int id) {
		driverService.deleteDriver(id);
		return helperForRegisteredDrivers();
	}

	public ModelAndView helperForRegisteredDrivers() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("new_drivers");
		mav.addObject("drivers", driverService.getNewlyAddedDrivers());
		mav.addObject("cabs", cabService.getNewlyAddedCabs());
		return mav;
	}

	@RequestMapping("/seeallbookings")
	public ModelAndView seeAllBookings() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("show_all_bookings");
		mav.addObject("bookings",  bookingService.getAllBookings());
		return mav;
	}
}
