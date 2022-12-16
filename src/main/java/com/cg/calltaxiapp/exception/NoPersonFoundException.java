package com.cg.calltaxiapp.exception;

public class NoPersonFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
		
	public NoPersonFoundException() {}
	
	public NoPersonFoundException(String msg) {
		super(msg);
	}
}
