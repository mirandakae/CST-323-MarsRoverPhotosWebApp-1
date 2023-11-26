package com.cst323.response;

import com.fasterxml.jackson.annotation.JsonProperty;

//This appplication was written by Daniel Rumfelt for the purpose of a class project. All methods, objects and graphics were designed by me
//and my fellow student on the team Miranda Barnes. CST-323 Grand Canyone University. 

public class MarsPhoto {

	/*
	 * The @JsonProperty("rover_id") annotation in my code is used to indicate
	 * that the roverId field should be serialized/deserialized with the name
	 * “rover_id”. This is commonly used when the JSON property names don’t match
	 * with the Java field names.
	 * 
	 */
	private Long id;
	private int sol;
	private MarsCamera camera;
	@JsonProperty("img_src")
	private String imgSrc;
	@JsonProperty("earth_date")
	private String earthDate;
	private MarsRover rover;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getSol() {
		return sol;
	}

	public void setSol(int sol) {
		this.sol = sol;
	}

	public MarsCamera getCamera() {
		return camera;
	}

	public void setCamera(MarsCamera camera) {
		this.camera = camera;
	}

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	public String getEarthDate() {
		return earthDate;
	}

	public void setEarthDate(String earthDate) {
		this.earthDate = earthDate;
	}

	public MarsRover getRover() {
		return rover;
	}

	public void setRover(MarsRover rover) {
		this.rover = rover;
	}

	@Override
	public String toString() {
		return "MarsPhoto [id=" + id + ", sol=" + sol + ", camera=" + camera + ", imgSrc=" + imgSrc + ", earthDate="
				+ earthDate + "]";
	}

}
