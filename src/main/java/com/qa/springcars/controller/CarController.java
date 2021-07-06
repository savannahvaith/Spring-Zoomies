package com.qa.springcars.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springcars.domain.Car;

@RestController
public class CarController {
	
	// Mapping URLS to METHODS
	
	// How can i specify the datatype of the arraylist?
	List<Car> vehicles = new ArrayList<>(); 
	
	// CRUD functionality
	
	// CREATE
	@PostMapping("/createCar")
	public String createCar(@RequestBody Car c) {
		this.vehicles.add(c);
		return "Successfully added car";
	}
	
	// READ
	@GetMapping("/readCars")
	public List<Car> getAllCars(){
		return this.vehicles;
	}
	
	
	// UPDATE
	
	// DELETE

}
