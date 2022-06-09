package com.food.dto;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;

public class FoodDto {
	
	
	private int foodId;
	
	@NotNull
	@Size(min=2,message="The Food First Name alteast 2 character")
	@Column(nullable = false)
	private String foodName;
	
	 
	@Column(nullable = false)
	private double foodPrice;
	
	@Min(20000)
	@Column(nullable = false)
	private int foodQuantity;

	
	public FoodDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FoodDto(String foodName, double foodPrice, int foodQuantity) {
		super();
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodQuantity = foodQuantity;
	}


	public FoodDto(int foodId, String foodName, double foodPrice, int foodQuantity) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodQuantity = foodQuantity;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public double getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}

	public int getFoodQuantity() {
		return foodQuantity;
	}

	public void setFoodQuantity(int foodQuantity) {
		this.foodQuantity = foodQuantity;
	}

 
}
