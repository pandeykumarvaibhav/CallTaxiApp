package com.cg.calltaxiapp.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_id")
	private int bookingID;

	@Column(name = "booked_date_time")
	private LocalDateTime bookedTimestamp;

	@Column(name = "source")
	private String source;

	@Column(name = "destination")
	private String destination;

	@Column(name = "amount")
	private double amount;

	@ManyToOne
	@JoinColumn(name = "cust_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "driver_id")
	private Driver driver;

	@Column(name = "status")
	private char status;

	public int getBookingID() {
		return bookingID;
	}

	public LocalDateTime getBookedTimestamp() {
		return bookedTimestamp;
	}

	public void setBookedTimestamp(LocalDateTime bookedTimestamp) {
		this.bookedTimestamp = bookedTimestamp;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public void addUser(User user) {
		this.user = user;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}

}
