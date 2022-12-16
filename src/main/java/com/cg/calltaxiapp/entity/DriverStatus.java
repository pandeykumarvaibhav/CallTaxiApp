package com.cg.calltaxiapp.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "driver_status")
public class DriverStatus implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "driver_id")
	private Driver driver;

	@OneToOne
	@JoinColumn(name = "cab_id")
	private Cab cab;

	@Column(name = "onservice", columnDefinition = "boolean default false")
	private Boolean onSerivce;

	@Column(name = "active", columnDefinition = "boolean default false")
	private Boolean active;

	public Boolean getOnSerivce() {
		return onSerivce;
	}

	public void setOnSerivce(Boolean onSerivce) {
		this.onSerivce = onSerivce;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Cab getCab() {
		return cab;
	}

	public void setCab(Cab cab) {
		this.cab = cab;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
