package com.cst323.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//This appplication was written by Daniel Rumfelt for the purpose of a class project. All methods, objects and graphics were designed by me
//and my fellow student on the team Miranda Barnes. CST-323 Grand Canyone University. 

/*
 * This class represents a table in my database. This class seems to be used for storing user preferences 
 * for Mars rover photos. Each instance of MarsPhotoEntity represents a user’s preference for a specific Mars rover’s photos.
 * The class has fields for the user’s ID, the Mars API rover data, the Mars sol (Martian solar day), 
 * and boolean fields for different cameras on the rover. The rememberPreferences field is used to determine 
 * whether the user’s preferences should be remembered for future requests.
 * The @Entity annotation at the top of the class declaration indicates that this class is a JPA entity. 
 * The @Table annotation is used to specify the name of the database table that this entity maps to.
 * Each field in the class has a corresponding getter and setter method. 
 * The @Id annotation is used to denote the primary key field of the entity. 
 * The @GeneratedValue annotation is used to specify how the primary key is generated. 
 * In this case, the strategy is GenerationType.IDENTITY, which means the persistence provider must assign primary keys for the entity 
 * using a database identity column.
 * The @Column annotation is used to specify the mapped column for a persistent property or field. 
 * If no Column annotation is specified, the default values apply.
 */

@Entity
@Table(name = "mars_api_preferences")
public class MarsPhotoEntity {

	private Long id;
	private Long userId;
	private String marsApiRoverData;
	private Integer marsSol;
	private Boolean cameraFhaz;
	private Boolean cameraRhaz;
	private Boolean cameraMast;
	private Boolean cameraChemcam;
	private Boolean cameraMahli;
	private Boolean cameraMardi;
	private Boolean cameraNavcam;
	private Boolean cameraPancam;
	private Boolean cameraMinites;
	private Boolean rememberPreferences;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(length = 20)
	public String getMarsApiRoverData() {
		return marsApiRoverData;
	}

	public void setMarsApiRoverData(String marsApiRoverData) {
		this.marsApiRoverData = marsApiRoverData;
	}

	public Integer getMarsSol() {
		return marsSol;
	}

	public void setMarsSol(Integer marsSol) {
		this.marsSol = marsSol;
	}

	public Boolean getCameraFhaz() {
		return cameraFhaz;
	}

	public void setCameraFhaz(Boolean cameraFhaz) {
		this.cameraFhaz = cameraFhaz;
	}

	public Boolean getCameraRhaz() {
		return cameraRhaz;
	}

	public void setCameraRhaz(Boolean cameraRhaz) {
		this.cameraRhaz = cameraRhaz;
	}

	public Boolean getCameraMast() {
		return cameraMast;
	}

	public void setCameraMast(Boolean cameraMast) {
		this.cameraMast = cameraMast;
	}

	public Boolean getCameraChemcam() {
		return cameraChemcam;
	}

	public void setCameraChemcam(Boolean cameraChemcam) {
		this.cameraChemcam = cameraChemcam;
	}

	public Boolean getCameraMahli() {
		return cameraMahli;
	}

	public void setCameraMahli(Boolean cameraMahli) {
		this.cameraMahli = cameraMahli;
	}

	public Boolean getCameraMardi() {
		return cameraMardi;
	}

	public void setCameraMardi(Boolean cameraMardi) {
		this.cameraMardi = cameraMardi;
	}

	public Boolean getCameraNavcam() {
		return cameraNavcam;
	}

	public void setCameraNavcam(Boolean cameraNavcam) {
		this.cameraNavcam = cameraNavcam;
	}

	public Boolean getCameraPancam() {
		return cameraPancam;
	}

	public void setCameraPancam(Boolean cameraPancam) {
		this.cameraPancam = cameraPancam;
	}

	public Boolean getCameraMinites() {
		return cameraMinites;
	}

	public void setCameraMinites(Boolean cameraMinites) {
		this.cameraMinites = cameraMinites;
	}

	public Boolean getRememberPreferences() {
		return rememberPreferences;
	}

	public void setRememberPreferences(Boolean rememberPreferences) {
		this.rememberPreferences = rememberPreferences;
	}

	@Override
	public String toString() {
		return "HomeControllerDTO [id=" + id + ", userId=" + userId + ", marsApiRoverData=" + marsApiRoverData
				+ ", marsSol=" + marsSol + ", cameraFhaz=" + cameraFhaz + ", cameraRhaz=" + cameraRhaz + ", cameraMast="
				+ cameraMast + ", cameraChemcam=" + cameraChemcam + ", cameraMahli=" + cameraMahli + ", cameraMardi="
				+ cameraMardi + ", cameraNavcam=" + cameraNavcam + ", cameraPancam=" + cameraPancam + ", cameraMinites="
				+ cameraMinites + ", rememberPreferences=" + rememberPreferences + "]";
	}

}
