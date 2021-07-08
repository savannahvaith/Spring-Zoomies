package com.qa.springcars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.springcars.domain.Car;
import com.qa.springcars.repo.CarRepo;

@Service // business logic!
public class CarServiceDB {
	
	// Dependency
	private CarRepo repo; 
	
	@Autowired
	public CarServiceDB(CarRepo repo) {
		this.repo = repo; 
	}
	
	// CRUD
	
	// CREATE = A method to add to the DB
	public String createCar(Car c) {
		this.repo.saveAndFlush(c);
// INSERT INTO CAR('make','model','engine','spoiler' VALUES (c.getMake(), c.getModel(), c.getEngine(), c.getSpoiler()); 
		return "Successfully added Car from REPO!";
	}
	
	// READ = A method to read from the DB
	public List<Car> getAllCars(){
		return this.repo.findAll();
// SELECT * FROM Car; 
	}
	
	// UPDATE = A method to replace an existing entry in the DB
//	public Car updateCar(Long id, Car newCar) {
//		Car existing = this.repo.findById(id); 
//	}
	
	// DELETE = A method to remove from the DB
	public void removeCar(Long id) {
		this.repo.deleteById(id);
	}
	
	
}
