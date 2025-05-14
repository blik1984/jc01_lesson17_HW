package com.edu.training.js.cofeeShop.entity;

public class Drink {

	private final int volumeOfWater;
	private final int volumeOfCoffee;
	private final int volumeOfMilk;

	private Drink(int volumeOfWater, int volumeOfCoffee, int volumeOfMilk) {

		this.volumeOfWater = volumeOfWater;
		this.volumeOfCoffee = volumeOfCoffee;
		this.volumeOfMilk = volumeOfMilk;
	}

	public static Drink getDrink(Coffee coffee) {

		int volumeOfWater = coffee.getComposition()[0];
		int volumeOfCoffee = coffee.getComposition()[1];
		int volumeOfMilk = coffee.getComposition()[2];
		return new Drink(volumeOfWater, volumeOfCoffee, volumeOfMilk);
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
