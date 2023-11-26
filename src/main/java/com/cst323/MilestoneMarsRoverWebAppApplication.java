package com.cst323;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

//This appplication was written by Daniel Rumfelt for the purpose of a class project. All methods, objects and graphics were designed by me
//and my fellow student on the team Miranda Barnes. CST-323 Grand Canyone University. 


@SpringBootApplication
public class MilestoneMarsRoverWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MilestoneMarsRoverWebAppApplication.class, args);
	}
	/* I wanted to see all the available beans I read on spring docs.
	 * @Bean public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
	 * return args -> {
	 * 
	 * System.out.println("Let's inspect the beans provided by Spring Boot:");
	 * 
	 * String[] beanNames = ctx.getBeanDefinitionNames(); Arrays.sort(beanNames);
	 * for (String beanName : beanNames) { System.out.println(beanName); }
	 * 
	 * }; }
	 */

}
