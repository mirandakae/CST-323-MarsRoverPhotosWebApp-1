package com.cst323;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.cst323.response.MarsRoverApiResponse;

public class NASAApiTest {
	
	@Test
	public void apiTest() {
		RestTemplate apiCall = new RestTemplate();	
		ResponseEntity<MarsRoverApiResponse>response = apiCall.getForEntity("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=2&api_key=DEMO_KEY", MarsRoverApiResponse.class);
		System.out.println(response.getBody());
	
	}

}
