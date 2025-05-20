package com.edu.training.js.coffeeshop.entity;

public class Drink {

	private final int volumeOfWater;
	private final int volumeOfCoffee;
	private final int volumeOfMilk;

	public Drink(CoffeeType coffee) {

		this.volumeOfWater = coffee.getWater();
		this.volumeOfCoffee = coffee.getCoffee();
		this.volumeOfMilk = coffee.getMilk();
	}

	public int getVolumeOfWater() {
		return volumeOfWater;
	}

	public int getVolumeOfCoffee() {
		return volumeOfCoffee;
	}

	public int getVolumeOfMilk() {
		return volumeOfMilk;
	}
}
