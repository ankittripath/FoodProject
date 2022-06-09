package com.food.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.food.dto.FoodDto;
import com.food.entity.Food;
import com.food.exception.FoodNotFoundException;
 
import com.food.repository.FoodRepository;
import com.food.services.FoodService;
 

@RestController
public class foodController {
	
	@Autowired
	FoodRepository foodRepository;
	
	@Autowired
	FoodService foodservice;
	
	@PostMapping("/addfood")
	public ResponseEntity<Food> addFood(@RequestBody @Valid FoodDto fooddto) {
		return new ResponseEntity<>(foodservice.addfood(fooddto),HttpStatus.CREATED);
	}
	
	
	@PutMapping("/updatefood/{id}")
	public ResponseEntity<Food> updateFood(@RequestBody @Valid FoodDto fooddto, @PathVariable int id  ) {
		 
		return new ResponseEntity<>(foodservice.updatefood(fooddto),HttpStatus.OK);
	}
	
	@GetMapping("/getfood/{id}")
	public ResponseEntity<Food> getFood(@PathVariable int id) throws FoodNotFoundException {
		
		return new ResponseEntity<>(foodservice.getFoodById(id),HttpStatus.OK);
	}
 
	
	 @GetMapping("/getfoodname/{foodName}")
	 public ResponseEntity<List<Food>> getFoodName(@PathVariable String foodName) throws FoodNotFoundException {
		 return new ResponseEntity<>(foodservice.getFoodByName(foodName),HttpStatus.OK);
	 }
	 
	 @GetMapping("/getfoodprice/{foodPrice}")
	 public ResponseEntity<List<Food>>  getFoodPrice(@PathVariable double foodPrice) throws FoodNotFoundException {
		 return new ResponseEntity<>(foodservice.getFoodByPrice(foodPrice),HttpStatus.OK);
	 }
	 
	 
	 @GetMapping("/getfoodquantity/{foodQuantity}")
	 public ResponseEntity<List<Food>> getFoodQuantity(@PathVariable int foodQuantity) throws FoodNotFoundException {
		 return new ResponseEntity<>(foodservice.getFoodByQuantity(foodQuantity),HttpStatus.OK);
	 }
	 
	 @GetMapping("/getfoodcontaining/{foodName}")
	 public ResponseEntity<List<Food>> getFoodContaining(@PathVariable String foodName) throws FoodNotFoundException{
		 return new ResponseEntity<>(foodservice.getFoodContaining(foodName),HttpStatus.OK);
	 }
	 
	 
	 @GetMapping("/findbystartswith/{foodName}")
		public ResponseEntity<List<Food>>  getByStartsWtih(@PathVariable String foodName) throws FoodNotFoundException {
			return new ResponseEntity<>(foodservice.findByStartsWith(foodName),HttpStatus.OK);
		}
	 
	 
	 @GetMapping("/findbyendswith/{foodName}")
	 public ResponseEntity<List<Food>> getByEndsWith(@PathVariable String foodName) throws FoodNotFoundException {
		 return new ResponseEntity<>(foodservice.findByEndsWith(foodName),HttpStatus.OK);
	 }	
 
}
