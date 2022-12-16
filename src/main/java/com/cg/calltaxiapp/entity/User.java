package com.cg.calltaxiapp.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cust_id")
	private int custID;

	@Column(name = "first_name", length = 20)
	@NotNull
	private String firstName;

	@Column(name = "last_name", length = 20)
	@NotNull
	private String lastName;

	@Column(name = "email", unique = true, length = 30)
	@NotNull
	private String email;

	@Column(name = "password", length = 100)
	@NotNull
	private String password;

	@Column(name = "phone_number", unique = true, length = 12)
	@NotNull
	private String phoneNumber;

	@Column(name = "registered_date")
	@NotNull
	private LocalDate registeredDate;

	@OneToMany(targetEntity = Booking.class, cascade = CascadeType.ALL, mappedBy = "user")
	private Set<Booking> bookings = new HashSet<>();

	User() {
	}

	public User(String firstName, String lastName, String email, String password, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}

	public void addBooking(Booking booking) {
		booking.addUser(this);
		this.bookings.add(booking);
	}

	public int getCustID() {
		return custID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(LocalDate registeredDate) {
		this.registeredDate = registeredDate;
	}

}
