package com.qa.springcars.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity// Marking it as a TABLE!
public class Car {
	
	@Id // Primary Key!
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO-INCREMENT
	private Long id; 
	
	// Variables 
	private String make; 
	private String model; 
	private int engine;
	private boolean spoiler;
	
	// Methods
	
	// Constructor - special method for the class
	
	// Default Constructor
	public Car() {}
	
	// Another constructor - with all parameters
	public Car(String make, String model, int engine, boolean spoiler) {
		this.make = make;
		this.model = model; 
		this.engine = engine; 
		this.spoiler = spoiler; 
	}

	// Getters and Setters
	
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getEngine() {
		return engine;
	}
	public void setEngine(int engine) {
		this.engine = engine;
	}
	public boolean isSpoiler() {
		return spoiler;
	}
	public void setSpoiler(boolean spoiler) {
		this.spoiler = spoiler;
	}
	
	

}
