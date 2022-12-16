package com.cg.calltaxiapp.exception;

public class InvalidLoginException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String page;
	private String message;

	public InvalidLoginException() {
	}

	public InvalidLoginException(String msg) {
		super(msg);
	}

	public InvalidLoginException(String message, String page) {
		this.page = page;
		this.message = message;
	}

	public String getPage() {
		return page;
	}

	public String getMessage() {
		return message;
	}
}
