package com.cst323.response;

import com.fasterxml.jackson.annotation.JsonProperty;

//This appplication was written by Daniel Rumfelt for the purpose of a class project. All methods, objects and graphics were designed by me
//and my fellow student on the team Miranda Barnes. CST-323 Grand Canyone University. 

public class MarsRover {

	/*
	 * The @JsonProperty("rover_id") annotation in my code is used to indicate
	 * that the roverId field should be serialized/deserialized with the name
	 * “rover_id”. This is commonly used when the JSON property names don’t match
	 * with the Java field names.
	 * 
	 */
	private Long id;
	private String name;
	@JsonProperty("landing_date")
	private String landingDate;
	@JsonProperty("launch_date")
	private String launchDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLandingDate() {
		return landingDate;
	}

	public void setLandingDate(String landingDate) {
		this.landingDate = landingDate;
	}

	public String getLaunchDate() {
		return launchDate;
	}

	public void setLaunchDate(String launchDate) {
		this.launchDate = launchDate;
	}

	@Override
	public String toString() {
		return "MarsRover [id=" + id + ", name=" + name + ", landingDate=" + landingDate + ", launchDate=" + launchDate
				+ "]";
	}

}
