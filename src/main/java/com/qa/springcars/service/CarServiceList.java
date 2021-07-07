package com.qa.springcars.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.springcars.domain.Car;

@Service // contains main business logic of our application!
public class CarServiceList {

	private List<Car> vehicles = new ArrayList<>(); // <- our list

	// METHODS TO MANIPULATE THE LIST

	// CREATE - a method to add to the list
	public String createCar(Car c) {
		this.vehicles.add(c);
		return "Successfully added car";
	}

	// READ - A method to read from the list
	public List<Car> getAllCars() {
		return this.vehicles;
	}

	// UPDATE - A method to replace an existing entry
	public Car updateCar(int index, Car newCar) {
		// replace the WHOLE object in a specific INDEX
		this.vehicles.set(index, newCar);
		return newCar;
	}
	
	// DELETE - Remove an entry from the list
	public void removeCar(int index) {
		this.vehicles.remove(index);	
	}
	
	

}
