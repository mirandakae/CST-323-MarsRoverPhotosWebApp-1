package com.cst323.service;

//This appplication was written by Daniel Rumfelt for the purpose of a class project. All methods, objects and graphics were designed by me
//and my fellow student on the team Miranda Barnes. CST-323 Grand Canyone University. 
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cst323.entity.MarsPhotoEntity;
import com.cst323.repository.DevicePreferencesRepository;
import com.cst323.response.MarsPhoto;
import com.cst323.response.MarsRoverApiResponse;

@Service
public class NasaMarsRoverApiService {

	/*
	 * it’s a good practice to inject a @Repository into a @Service and then inject
	 * that @Service into a @Controller or @RestController. This follows the single
	 * responsibility principle and takes advantage of Spring’s singleton rule. By
	 * injecting the @Repository into the @Service, you’re ensuring that the service
	 * layer handles the business logic while the repository layer handles the data
	 * access logic. This makes my code more modular, easier to maintain, and
	 * allows for better separation of concerns.
	 * 
	 */
	@Autowired
	DevicePreferencesRepository deviceRepo;

	private static final String API_KEY = "FUiIiPCgBfQRHwKXgyyiTJ91dFNXAx4hgGc5g04L";

	private Map<String, List<String>> validCameras = new HashMap<>();

	public NasaMarsRoverApiService() {
		validCameras.put("Opportunity", Arrays.asList("FHAZ", "RHAZ", "NAVCAM", "PANCAM", "MINITES"));
		validCameras.put("Curiosity", Arrays.asList("FHAZ", "RHAZ", "MAST", "CHEMCAM", "MAHLI", "MARDI", "NAVCAM"));
		validCameras.put("Spirit", Arrays.asList("FHAZ", "RHAZ", "NAVCAM", "PANCAM", "MINITES"));
	}

	/*
	 * This method, getRoverData(MarsPhotoEntity photoEntity), is used to fetch data
	 * from the Mars Rover API.
	 * 
	 * It creates a new instance of RestTemplate, which is a synchronous HTTP client
	 * that Spring provides for consuming web services. It gets the API endpoints
	 * using the getApiUrlEnpoints(photoEntity) method. It initializes an empty list
	 * of MarsPhoto objects and a new MarsRoverApiResponse object. It then iterates
	 * over each API endpoint URL. For each URL, it makes a GET request to the Mars
	 * Rover API and retrieves a MarsRoverApiResponse. It adds all the photos from
	 * the API response to the photos list. After it has iterated over all the URLs
	 * and collected all the photos, it sets the photos list in the response object.
	 * It then returns the response object, which now contains all the photos from
	 * the Mars Rover API.
	 * 
	 * This method throws IllegalAccessException, IllegalArgumentException, and
	 * InvocationTargetException. These exceptions would typically be thrown by the
	 * getApiUrlEnpoints(photoEntity) method if it uses reflection to dynamically
	 * invoke methods based on the photoEntity.
	 * 
	 */
	public MarsRoverApiResponse getRoverData(MarsPhotoEntity photoEntity)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		RestTemplate rt = new RestTemplate();

		List<String> apiUrlEnpoints = getApiUrlEnpoints(photoEntity);
		List<MarsPhoto> photos = new ArrayList<>();
		MarsRoverApiResponse response = new MarsRoverApiResponse();

		apiUrlEnpoints.stream().forEach(url -> {
			MarsRoverApiResponse apiResponse = rt.getForObject(url, MarsRoverApiResponse.class);
			photos.addAll(apiResponse.getPhotos());
		});

		response.setPhotos(photos);

		return response;
	}

	public List<String> getApiUrlEnpoints(MarsPhotoEntity photoEntity)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		List<String> urls = new ArrayList<>();

		// I wanted to try Java Reflection as I have read about it on my spare time.
		// Rarely used I seen where it may work well in this case.
		// I'm getting the methods from MarsPhotoEntity and getting methods for get
		// cameras also return true and getting the camera name from the
		// method name. Then getting based on a key getting valid cameras and matching
		// against the camera name and adding to the Uri.
		Method[] methods = photoEntity.getClass().getMethods();

		// This code will grab all getCamera* methods and (if value returns true) then
		// we will build a API URL to
		// call in order to fetch pictures for a given rover / camera / sol.
		for (Method method : methods) {
			if (method.getName().indexOf("getCamera") > -1 && Boolean.TRUE.equals(method.invoke(photoEntity))) {
				String cameraName = method.getName().split("getCamera")[1].toUpperCase();
				if (validCameras.get(photoEntity.getMarsApiRoverData()).contains(cameraName)) {
					urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/" + photoEntity.getMarsApiRoverData()
							+ "/photos?sol=" + photoEntity.getMarsSol() + "&api_key=" + API_KEY + "&camera="
							+ cameraName);
				}
			}
		}

		return urls;
	}

	public Map<String, List<String>> getValidCameras() {
		return validCameras;
	}

	public void setValidCameras(Map<String, List<String>> validCameras) {
		this.validCameras = validCameras;
	}

	public MarsPhotoEntity save(MarsPhotoEntity photoEntity) {
		return deviceRepo.save(photoEntity);

	}

	public MarsPhotoEntity findByUserId(Long userId) {
		return deviceRepo.findByUserId(userId);
	}

}
