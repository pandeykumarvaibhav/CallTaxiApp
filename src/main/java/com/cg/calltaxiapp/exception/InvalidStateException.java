package com.cg.calltaxiapp.exception;

import com.cg.calltaxiapp.entity.User;

public class InvalidStateException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private User user;
	private String message;
	
	public InvalidStateException() {}
	
	public InvalidStateException(String msg) {
		super(msg);
	}
	
	public InvalidStateException(User user) {
		this.user = user;
	}
	
	public InvalidStateException(User user, String message) {
		this.user = user;
		this.message = message;
	}
	
	public User getUser() {
		return user;
	}
	
	public String getMessage() {
		return message;
	}
}
