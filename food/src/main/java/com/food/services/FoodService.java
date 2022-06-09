package com.food.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.food.dto.FoodDto;
import com.food.entity.Food;
import com.food.exception.FoodNotFoundException;

import com.food.repository.FoodRepository;

@Service
public class FoodService {

	@Autowired
	FoodRepository foodrepository;

	public Food addfood(FoodDto fooddto) {
		// TODO Auto-generated method stub

		Food food = new Food();
		food.setFoodName(fooddto.getFoodName());
		food.setFoodPrice(fooddto.getFoodPrice());
		food.setFoodQuantity(fooddto.getFoodQuantity());
		return foodrepository.save(food);
	}

	public Food updatefood(FoodDto fooddto) {
		// TODO Auto-generated method stub
		Food food = new Food();
		food.setFoodId(fooddto.getFoodId());
		food.setFoodName(fooddto.getFoodName());
		food.setFoodPrice(fooddto.getFoodPrice());
		food.setFoodQuantity(fooddto.getFoodQuantity());
		return foodrepository.save(food);
	}

	public Food getFoodById(int id) throws FoodNotFoundException {
		// TODO Auto-generated method stub
		try {
			return foodrepository.findById(id).get();
		} catch (NoSuchElementException e) {
			throw new FoodNotFoundException("Food is not present");
		}

	}

	public List<Food> getFoodByName(String foodName) throws FoodNotFoundException {
		// TODO Auto-generated method stub
		if ( foodrepository.findByFoodName(foodName).isEmpty()) {
			throw new FoodNotFoundException("Food not found");
		} else {
			return foodrepository.findByFoodName(foodName);
		}
	}

	public List<Food> getFoodByPrice(double foodPrice) throws FoodNotFoundException {
		// TODO Auto-generated method stub
		 
		if(foodrepository.findByFoodPrice(foodPrice).isEmpty()) {
			throw new FoodNotFoundException("Food Not Found");
		}else {
			return foodrepository.findByFoodPrice(foodPrice);
		}
	}

	public List<Food> getFoodByQuantity(int foodQuantity) throws FoodNotFoundException {
		// TODO Auto-generated method stub
		if(foodrepository.findByFoodQuantity(foodQuantity).isEmpty()) {
			throw new FoodNotFoundException("Invalid Input");
		}else {
			return foodrepository.findByFoodQuantity(foodQuantity);
		}
	}

	public List<Food> getFoodContaining(String foodName) throws FoodNotFoundException {
		// TODO Auto-generated method stub
		if(foodrepository.findByFoodNameContains(foodName).isEmpty()) {
			throw new FoodNotFoundException("Please Enter proper input");
		}else {
			return foodrepository.findByFoodNameContains(foodName);
		}
	}

	public List<Food> findByStartsWith(String foodName) throws FoodNotFoundException {
		// TODO Auto-generated method stub
		if(foodrepository.findByFoodNameStartsWith(foodName).isEmpty()) {
			throw new FoodNotFoundException("The input which you search is not matching in startwiths words");
		}else {
			return foodrepository.findByFoodNameStartsWith(foodName);
		}
		
	}

	public List<Food> findByEndsWith(String foodName) throws FoodNotFoundException {
		// TODO Auto-generated method stub
		if(foodrepository.findByFoodNameEndsWith(foodName).isEmpty()) {
			throw new FoodNotFoundException("The input which you search is not matching in endwith words");
		}
		return foodrepository.findByFoodNameEndsWith(foodName);
	}
	
	

}
