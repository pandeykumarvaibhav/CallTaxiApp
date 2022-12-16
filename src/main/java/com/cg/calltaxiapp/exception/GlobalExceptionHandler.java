package com.cg.calltaxiapp.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(DuplicateValueException.class)
	public ModelAndView duplicateValue(DuplicateValueException dve) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("invalid");
		mav.addObject("message", dve.getMessage());
		return mav;
	}
	
	@ExceptionHandler(NoPersonFoundException.class)
	public ModelAndView noPersonFound(NoPersonFoundException npf) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("invalid");
		mav.addObject("message", npf.getMessage());
		return mav;
	}
	
	@ExceptionHandler(InvalidLoginException.class)
	public ModelAndView invalidLogin(InvalidLoginException ile) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login_fail");
		mav.addObject("message", ile.getMessage());
		if(ile.getPage().equals("driver"))
		mav.addObject("page", "login");
		else if(ile.getPage().equals("user"))
		mav.addObject("page", "login");
		else
		mav.addObject("page", "admin");
		return mav;
	}
	
	@ExceptionHandler(InvalidStateException.class)
	public ModelAndView invalidState(InvalidStateException ise) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("error_for_driver_inactive");
		mav.addObject("user", ise.getUser());
		mav.addObject("message", ise.getMessage());
		return mav;
	}
	
}
