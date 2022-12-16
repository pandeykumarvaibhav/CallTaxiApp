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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "registered_driver")
public class Driver {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "driver_id")
	private int driverID;

	@Column(name = "first_name")
	@NotNull
	private String firstName;

	@Column(name = "last_name")
	@NotNull
	private String lastName;

	@Column(name = "email", unique = true)
	@NotNull
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "phone_number", length = 10, unique=true)
	private String phoneNumber;

	@Column(name = "registered_date")
	private LocalDate registeredDate;

	@Column(name = "license_number", unique = true)
	private String licenseNumber;

	@Column(name = "aadhar_number", unique = true)
	private String aadharNumber;

	@Column(name = "verified", columnDefinition = "boolean default false")
	private Boolean verify;

	@OneToOne(targetEntity = Cab.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "cab_id")
	private Cab cab;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "driver")
	private Set<Booking> bookings = new HashSet<>();

	@OneToOne(targetEntity = DriverStatus.class, mappedBy = "driver", cascade = CascadeType.ALL)
	private DriverStatus driverStatus;

	public Boolean getVerify() {
		return verify;
	}

	public void setVerify(Boolean verify) {
		this.verify = verify;
	}

	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

	public DriverStatus getDriverStatus() {
		return driverStatus;
	}

	public void setDriverStatus(DriverStatus driverStatus) {
		this.driverStatus = driverStatus;
	}

	public Driver() {
	}

	public Driver(String firstName, String lastName, String email, String password, String phoneNumber,
			LocalDate registeredDate, String licenseNumber, String aadharNumber, Cab cab) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.registeredDate = registeredDate;
		this.licenseNumber = licenseNumber;
		this.aadharNumber = aadharNumber;
		this.verify = false;
		this.cab = cab;
	}

	public int getDriverID() {
		return driverID;
	}

	public void setDriverID(int driverID) {
		this.driverID = driverID;
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

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public boolean isVerify() {
		return verify;
	}

	public void setVerify(boolean verify) {
		this.verify = verify;
	}

	public Cab getCab() {
		return cab;
	}

	public void setCab(Cab cab) {
		cab.setDriver(this);
		this.cab = cab;
	}

	public void addBooking(Booking booking) {
		booking.setDriver(this);
		this.bookings.add(booking);
	}

}
