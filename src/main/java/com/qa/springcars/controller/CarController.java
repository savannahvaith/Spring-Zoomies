package com.qa.springcars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springcars.domain.Car;
import com.qa.springcars.service.CarServiceDB;

@RestController
//@RequestMapping("/Car")
public class CarController {
	
	// Mapping URLS to METHODS
	
	private CarServiceDB service; 
	
	// PULL DOWN THE OBJECT FROM THE BEANBAG
	
	@Autowired // <- Optional
	public CarController(CarServiceDB service) {
		this.service = service;
	}
	
	@GetMapping("/test2") // @TypeOfRequest("location")
	public String thisMethod() {
		return "Hello from CAR CONTROLLER"; 
	}
	
	// CRUD functionality
	
	// CREATE
	@PostMapping("/createCar")
	public ResponseEntity<String> createCar(@RequestBody Car c) {
		this.service.createCar(c);
		return new ResponseEntity<String>("Successfully added car",HttpStatus.CREATED);
	}
	
	// READ
	@GetMapping("/readCars")
	public ResponseEntity<List<Car>> getAllCars(){
		//return new ResponseEntity<List<Car>>(this.vehicles, HttpStatus.OK);
		// OR: 
		return ResponseEntity.ok(this.service.getAllCars());
	}
	
	// UPDATE - PUT (REPLACE) / PATCH (UPDATE an ELEMENT) 
//	@PutMapping("/updateCar/{index}")
//	public ResponseEntity<Car> updateCar(@PathVariable int index, @RequestBody Car newCar) {
//		
//		// replace the WHOLE object in a specific INDEX
//		this.service.updateCar(index, newCar);
//		
//		return new ResponseEntity<Car>(newCar, HttpStatus.ACCEPTED);
//		
//		// OR Set each individual variable: 
////		Car oldCar = this.vehicles.get(index); 
////		oldCar.setMake(newCar.getMake());
////		oldCar.setModel(newCar.getModel());
////		oldCar.setEngine(newCar.getEngine());
////		oldCar.setSpoiler(newCar.isSpoiler());
//	}
	
	// DELETE - BY INDEX
	@DeleteMapping("/removeCar/{index}")
	public ResponseEntity removeCar(@PathVariable Long index) {
		this.service.removeCar(index);
		return new ResponseEntity(HttpStatus.NO_CONTENT);		
	}

}
