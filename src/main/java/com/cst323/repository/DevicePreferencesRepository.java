package com.cst323.repository;

//This appplication was written by Daniel Rumfelt for the purpose of a class project. All methods, objects and graphics were designed by me
//and my fellow student on the team Miranda Barnes. CST-323 Grand Canyone University. 

import org.springframework.data.jpa.repository.JpaRepository;

import com.cst323.entity.MarsPhotoEntity;

/* This code defines an interface DevicePreferencesRepository that extends JpaRepository. 
 * This interface is used to interact with the database for MarsPhotoEntity objects.
 * The JpaRepository interface is a Spring Data JPA repository that provides built-in methods 
 * for common CRUD operations. By extending JpaRepository, your DevicePreferencesRepository 
 * will inherit these methods.In addition to the methods provided by JpaRepository, I 
 * also defined a custom method findByUserId(Long userId). Spring Data JPA will automatically 
 * implement this method. It will execute a query that finds a MarsPhotoEntity object 
 * where the userId field matches the provided userId.
 */

public interface DevicePreferencesRepository extends JpaRepository<MarsPhotoEntity, Long> {

	// I'm leaving the below code commented out, it can be used as a reference for
	// how to create custom queries... but in this case we don't need a custom query
	// because we're
	// using the built in "findBy....." naming convention.
	// @Query("select dto from photoEntity dto where userId = :userId")
	// @Query(value="select * from mars_api_preferences where user_id = :userId",
	// nativeQuery=true)
	MarsPhotoEntity findByUserId(Long userId);

}
