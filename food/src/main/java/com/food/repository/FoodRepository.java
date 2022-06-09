package com.food.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.dto.FoodDto;
import com.food.entity.Food;

public interface FoodRepository extends JpaRepository<Food, Integer> {
 
	List<Food> findByFoodName(String foodName);
	List<Food> findByFoodPrice(double foodPrice);
	
	List<Food> findByFoodQuantity(int foodQuantity);
	List<Food> findByFoodNameContains(String foodName);
	
	List<Food> findByFoodNameStartsWith(String foodName);
	
	List<Food> findByFoodNameEndsWith(String foodName);
	
	 
}
