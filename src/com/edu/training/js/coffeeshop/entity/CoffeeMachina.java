package com.edu.training.js.coffeeshop.entity;

import java.util.Objects;

public class CoffeeMachina {
	private final String id;
	private final int SIZE_OF_WATER;
	private final int SIZE_OF_COFFEE;
	private final int SIZE_OF_MILK;
	private int levelWater;
	private int levelCoffee;
	private int levelMilk;

	public CoffeeMachina(String id, int sizeOfWater, int sizeOfCoffee, int sizeOfMilk, int startLevelWater,
			int startLevelCoffee, int startLevelMilk) {
		this.id = id;
		this.SIZE_OF_WATER = sizeOfWater;
		this.SIZE_OF_COFFEE = sizeOfCoffee;
		this.SIZE_OF_MILK = sizeOfMilk;
		this.levelWater = startLevelWater;
		this.levelCoffee = startLevelCoffee;
		this.levelMilk = startLevelMilk;

	}

	public Drink makeDrink(CoffeeType coffee) {

		if (checkEnoughIngredients(coffee)) {
			Drink drink = new Drink(coffee);
			consumptionOfWater(coffee.getWater());
			consumptionOfCoffee(coffee.getCoffee());
			consumptionOfMilk(coffee.getMilk());
			return drink;
		} else {
			throw new RuntimeException("Alarma!!!");
		}
	}


	public boolean checkEnoughIngredients(CoffeeType coffee) {
		if (levelWater < coffee.getWater()) {
			return false;
		} else if (levelCoffee < coffee.getCoffee()) {
			return false;
		} else if (levelMilk < coffee.getMilk()) {
			return false;
		}
		return true;
	}

	public void addWater() {
		levelWater = SIZE_OF_WATER;
	}

	public void addCoffee() {
		levelCoffee = SIZE_OF_COFFEE;
	}

	public void addMilk() {
		levelMilk = SIZE_OF_MILK;
	}

	/*
	 * Методы consumptionOfWater(), consumptionOfCoffee() и consumptionOfMilk()
	 * реализуют уменьшение запаса ингридиентов в процессе приготовления напитков
	 */
	public boolean consumptionOfWater(int water) {
		if (levelWater < water) {
			return false;
		}
		levelWater -= water;
		return true;
	}

	public boolean consumptionOfCoffee(int coffee) {
		if (levelCoffee < coffee) {
			return false;
		}
		levelCoffee -= coffee;
		return true;
	}

	public boolean consumptionOfMilk(int milk) {
		if (levelMilk < milk) {
			return false;
		}
		levelMilk -= milk;
		return true;
	}

	public int getLevelWater() {
		return levelWater;
	}

	private void setLevelWater(int levelWater) {
		if (levelWater <= SIZE_OF_WATER) {
			this.levelWater = levelWater;
		} else {
			this.levelWater = SIZE_OF_WATER;
		}
	}

	public int getLevelCoffee() {
		return levelCoffee;
	}

	private void setLevelCoffee(int levelCoffee) {
		if (levelCoffee <= SIZE_OF_COFFEE) {
			this.levelCoffee = levelCoffee;
		} else {
			this.levelCoffee = SIZE_OF_COFFEE;
		}
	}

	public int getLevelMilk() {
		return levelMilk;
	}

	private void setLevelMilk(int levelMilk) {
		if (levelMilk <= SIZE_OF_MILK) {
			this.levelMilk = levelMilk;
		} else {
			this.levelMilk = SIZE_OF_MILK;
		}
	}

	public String getId() {
		return id;
	}

	public int getSizeOfWater() {
		return SIZE_OF_WATER;
	}

	public int getSizeOfCoffee() {
		return SIZE_OF_COFFEE;
	}

	public int getSizeOfMilk() {
		return SIZE_OF_MILK;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, levelCoffee, levelMilk, levelWater, SIZE_OF_COFFEE, SIZE_OF_MILK, SIZE_OF_WATER);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CoffeeMachina other = (CoffeeMachina) obj;
		return Objects.equals(id, other.id) && levelCoffee == other.levelCoffee && levelMilk == other.levelMilk
				&& levelWater == other.levelWater && SIZE_OF_COFFEE == other.SIZE_OF_COFFEE
				&& SIZE_OF_MILK == other.SIZE_OF_MILK && SIZE_OF_WATER == other.SIZE_OF_WATER;
	}

	@Override
	public String toString() {
		return "CoffeeMachina [id=" + id + ", sizeOfWater=" + SIZE_OF_WATER + ", sizeOfCoffee=" + SIZE_OF_COFFEE
				+ ", sizeOfMilk=" + SIZE_OF_MILK + ", levelWater=" + levelWater + ", levelCoffee=" + levelCoffee
				+ ", levelMilk=" + levelMilk + "]";
	}
}
