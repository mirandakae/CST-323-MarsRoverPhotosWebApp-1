package com.cst323.response;

import java.util.ArrayList;
import java.util.List;
//This appplication was written by Daniel Rumfelt for the purpose of a class project. All methods, objects and graphics were designed by me
//and my fellow student on the team Miranda Barnes. CST-323 Grand Canyone University. 

/*
 * This code defines a class that represents a response from the Mars Rover API.
 * It contains a list of MarsPhoto objects, which are presumably defined
 * elsewhere in our code.
 */
public class MarsRoverApiResponse {

	List<MarsPhoto> photos = new ArrayList<>();

	/*
	 * The getPhotos() method is a getter that returns the current list of photos.
	 */
	
	public List<MarsPhoto> getPhotos() {
		return photos;
	}

	/*
	 * The setPhotos(List<MarsPhoto> photos) method is a setter that allows me to
	 * replace the current list of photos with a new one.
	 */
	public void setPhotos(List<MarsPhoto> photos) {
		this.photos = photos;
	}

	@Override
	public String toString() {
		return "MarsRoverApiResponse [photos=" + photos + "]";
	}

}
