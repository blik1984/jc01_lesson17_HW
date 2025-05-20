package com.edu.training.js.coffeeshop.entity;

/*
 * Храним рецепты
 */

public enum CoffeeType {

	AMERICANO(2, 1, 0), ESPRESSO(1, 1, 0), LATTE(1, 1, 1);

	private int water;
	private int coffee;
	private int milk;

	CoffeeType(int water, int coffee, int milk) {
		this.water = water;
		this.coffee = coffee;
		this.milk = milk;
	}

	public int getWater() {
		return water;
	}

	public int getCoffee() {
		return coffee;
	}

	public int getMilk() {
		return milk;
	}

}
