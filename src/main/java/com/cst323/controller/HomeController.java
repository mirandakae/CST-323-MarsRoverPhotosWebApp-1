package com.cst323.controller;

import java.lang.reflect.InvocationTargetException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import com.cst323.entity.MarsPhotoEntity;
import com.cst323.response.MarsRoverApiResponse;
import com.cst323.service.NasaMarsRoverApiService;
//This appplication was written by Daniel Rumfelt for the purpose of a class project. All methods, objects and graphics were designed by me
//and my fellow student on the team Miranda Barnes. CST-323 Grand Canyone University. 

@Controller
public class HomeController {

	/*
	 * @Autowired is used to automatically inject the NasaMarsRoverApiService
	 * dependency into this class. Spring will try to find a bean of
	 * NasaMarsRoverApiService type in the application context and assign it to the
	 * roverService field. This way, I don’t have to manually create an instance
	 * of NasaMarsRoverApiService using the new keyword.
	 * 
	 */
	@Autowired
	private NasaMarsRoverApiService roverService;

	/*
	 * @GetMapping annotation for handling HTTP GET requests. This method seems to
	 * be the controller for the home view (“/”). The method takes in a ModelMap,
	 * userId, and createUser as parameters. It fetches Mars Rover data based on the
	 * userId and adds it to the model. If createUser is true and userId is null, it
	 * saves a new photoEntity. If userId is not null, it tries to find an existing
	 * photoEntity for the userId. If it doesn’t find one, it creates a new
	 * photoEntity. The method then fetches the Mars Rover data for the photoEntity
	 * and adds it to the model. It also adds the photoEntity and the valid cameras
	 * for the rover to the model.
	 * 
	 * If photoEntity.getRememberPreferences() is false and userId is not null, it
	 * saves a new photoEntity with default preferences.
	 * 
	 */
	@GetMapping("/")
	public String getHomeView(ModelMap model, Long userId, Boolean createUser)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		MarsPhotoEntity photoEntity = createDefaultPhotoEntity(userId);

		if (Boolean.TRUE.equals(createUser) && userId == null) {
			photoEntity = roverService.save(photoEntity);
		} else {
			photoEntity = roverService.findByUserId(userId);
			if (photoEntity == null) {
				photoEntity = createDefaultPhotoEntity(userId);
			}
		}
		MarsRoverApiResponse roverData = roverService.getRoverData(photoEntity);
		model.put("roverData", roverData);
		model.put("photoEntity", photoEntity);
		model.put("validCameras", roverService.getValidCameras().get(photoEntity.getMarsApiRoverData()));
		if (!Boolean.TRUE.equals(photoEntity.getRememberPreferences()) && userId != null) {
			MarsPhotoEntity defaultHomeDto = createDefaultPhotoEntity(userId);
			roverService.save(defaultHomeDto);
		}

		return "index";

	}

	/*
	 * The method takes a userId as a parameter. If userId is not null, it calls the
	 * roverService.findByUserId(userId) method to fetch the MarsPhotoEntity
	 * associated with that userId. If userId is null, it calls the
	 * createDefaultPhotoEntity(userId) method to create a default MarsPhotoEntity.
	 * 
	 * The @ResponseBody annotation indicates that the MarsPhotoEntity returned by
	 * the method should be bound to the web response body. Spring’s
	 * HttpMessageConverter is used to convert the MarsPhotoEntity to JSON or XML
	 * format, depending on what type of data the client can accept (as specified in
	 * the request’s “Accept” header).
	 * 
	 */
	@GetMapping("/savedPreferences")
	@ResponseBody
	public MarsPhotoEntity getSavedPreferences(Long userId) {
		if (userId != null)
			return roverService.findByUserId(userId);
		else
			return createDefaultPhotoEntity(userId);
	}

	/*
	 * The createDefaultPhotoEntity(Long userId) method is a private helper method
	 * that creates a new MarsPhotoEntity object with some default values.
	 * 
	 * It creates a new MarsPhotoEntity object. It sets the marsApiRoverData field
	 * of the photoEntity to “Opportunity”. It sets the marsSol field of the
	 * photoEntity to 1. It sets the userId field of the photoEntity to the userId
	 * passed into the method. It returns the photoEntity. This method is useful for
	 * creating a default MarsPhotoEntity when one is not found for a given userId
	 * or when a new user is being created.
	 * 
	 */
	private MarsPhotoEntity createDefaultPhotoEntity(Long userId) {
		MarsPhotoEntity photoEntity = new MarsPhotoEntity();
		photoEntity.setMarsApiRoverData("Opportunity");
		photoEntity.setMarsSol(1);
		photoEntity.setUserId(userId);
		return photoEntity;
	}

	/*
	 * @PostMapping("/"), handles HTTP POST requests made to the root (“/”)
	 * endpoint.
	 * 
	 * It takes a MarsPhotoEntity object as a parameter. This object should be
	 * included in the body of the HTTP POST request. It calls the
	 * roverService.save(photoEntity) method to save the photoEntity. The save
	 * method should persist the photoEntity to a database and return the persisted
	 * entity. The returned entity is then assigned back to the photoEntity
	 * variable. It returns a redirect view to the root (“/”) endpoint with a userId
	 * query parameter. The value of the userId parameter is the userId of the
	 * photoEntity. This method is typically used to handle form submissions. When a
	 * form is submitted with a MarsPhotoEntity, this method will save the entity
	 * and then redirect the user back to the home view, passing along the userId as
	 * a query parameter.
	 * 
	 */
	@PostMapping("/")
	public String postHomeView(MarsPhotoEntity photoEntity) {
		photoEntity = roverService.save(photoEntity);
		return "redirect:/?userId=" + photoEntity.getUserId();
	}
}
