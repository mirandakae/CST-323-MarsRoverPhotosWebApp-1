package com.cst323.response;

//This appplication was written by Daniel Rumfelt for the purpose of a class project. All methods, objects and graphics were designed by me
//and my fellow student on the team Miranda Barnes. CST-323 Grand Canyone University. 
import com.fasterxml.jackson.annotation.JsonProperty;

public class MarsCamera {

	/*
	 * The @JsonProperty("rover_id") annotation in my code is used to indicate
	 * that the roverId field should be serialized/deserialized with the name
	 * “rover_id”. This is commonly used when the JSON property names don’t match
	 * with the Java field names.
	 */
	private Long id;
	private String name;
	@JsonProperty("rover_id")
	private Long roverId;
	@JsonProperty("full_name")
	private String fullName;

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

	public Long getRoverId() {
		return roverId;
	}

	public void setRoverId(Long roverId) {
		this.roverId = roverId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}
