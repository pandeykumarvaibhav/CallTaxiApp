package com.cg.calltaxiapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cab")
public class Cab {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cab_id")
	private int cabID;

	@Column(name = "cab_company")
	private String cabCompany;

	@Column(name = "cab_model")
	private String cabModel;

	@Column(name = "verified", columnDefinition = "boolean default false")
	private Boolean verify;

	@OneToOne(mappedBy = "cab")
	private Driver driver;

	@OneToOne(targetEntity = DriverStatus.class, mappedBy = "cab")
	private DriverStatus driverStatus;

	public DriverStatus getDriverStatus() {
		return driverStatus;
	}

	public void setDriverStatus(DriverStatus driverStatus) {
		this.driverStatus = driverStatus;
	}

	public Cab(String cabCompany, String cabModel) {
		this.cabCompany = cabCompany;
		this.cabModel = cabModel;
	}

	public Cab() {
	}

	public int getCabID() {
		return cabID;
	}

	public void setCabID(int cabID) {
		this.cabID = cabID;
	}

	public String getCabCompany() {
		return cabCompany;
	}

	public void setCabCompany(String cabCompany) {
		this.cabCompany = cabCompany;
	}

	public String getCabModel() {
		return cabModel;
	}

	public void setCabModel(String cabModel) {
		this.cabModel = cabModel;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Boolean getVerify() {
		return verify;
	}

	public void setVerify(Boolean verify) {
		this.verify = verify;
	}
}
