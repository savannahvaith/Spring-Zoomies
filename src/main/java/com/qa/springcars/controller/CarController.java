package com.qa.springcars.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ResponseEntity<String> createCar(@RequestBody Car c) {
		this.vehicles.add(c);
		return new ResponseEntity<String>("Successfully added car",HttpStatus.CREATED);
	}
	
	// READ
	@GetMapping("/readCars")
	public ResponseEntity<List<Car>> getAllCars(){
		//return new ResponseEntity<List<Car>>(this.vehicles, HttpStatus.OK);
		// OR: 
		return ResponseEntity.ok(this.vehicles);
	}
	
	// UPDATE - PUT (REPLACE) / PATCH (UPDATE an ELEMENT) 
	@PatchMapping("/updateCar/{index}")
	public ResponseEntity<Car> updateCar(@PathVariable int index, @RequestBody Car newCar) {
		
		// replace the WHOLE object in a specific INDEX
		this.vehicles.set(index, newCar);
		
		return new ResponseEntity<Car>(newCar, HttpStatus.ACCEPTED);
		
		// OR Set each individual variable: 
//		Car oldCar = this.vehicles.get(index); 
//		oldCar.setMake(newCar.getMake());
//		oldCar.setModel(newCar.getModel());
//		oldCar.setEngine(newCar.getEngine());
//		oldCar.setSpoiler(newCar.isSpoiler());
	}
	
	// DELETE - BY INDEX
	@DeleteMapping("/removeCar/{index}")
	public ResponseEntity removeCar(@PathVariable int index) {
		this.vehicles.remove(index);
		return new ResponseEntity(HttpStatus.NO_CONTENT);		
	}

}
