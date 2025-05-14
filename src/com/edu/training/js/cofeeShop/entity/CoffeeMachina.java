package com.edu.training.js.cofeeShop.entity;

import java.util.Objects;

import com.edu.training.js.cofeeShop.ui.Show;

public class CoffeeMachina {
	private final String id;
	private final int sizeOfWater;
	private final int sizeOfCoffee;
	private final int sizeOfMilk;
	private int levelWater;
	private int levelCoffee;
	private int levelMilk;

	public CoffeeMachina(String id, int sizeOfWater, int sizeOfCoffee, int sizeOfMilk, int startLevelWater,
			int startLevelCoffee, int startLevelMilk) {
		this.id = id;
		this.sizeOfWater = sizeOfWater;
		this.sizeOfCoffee = sizeOfCoffee;
		this.sizeOfMilk = sizeOfMilk;
		this.levelWater = startLevelWater;
		this.levelCoffee = startLevelCoffee;
		this.levelMilk = startLevelMilk;

	}

	public boolean makeDrink(Coffee coffee) {

		Drink drink = Drink.getDrink(coffee);

		if (checkIngredients(drink)) {
			consumptionOfWater(drink.getVolumeOfWater());
			consumptionOfCoffee(drink.getVolumeOfCoffee());
			consumptionOfMilk(drink.getVolumeOfMilk());
			Show.messageToUser("Кофе готов!");
			return true;
		} else {
			return false;
		}
	}

	public boolean checkIngredients(Drink drink) {
		if (levelWater < drink.getVolumeOfWater()) {
			return false;
		} else if (levelCoffee < drink.getVolumeOfCoffee()) {
			return false;
		} else if (levelMilk < drink.getVolumeOfMilk()) {
			return false;
		}
		return true;
	}

	public void addWater() {
		levelWater = sizeOfWater;
	}

	public void addCoffee() {
		levelCoffee = sizeOfCoffee;
	}

	public void addMilk() {
		levelMilk = sizeOfMilk;
	}

	/*
	 * Методы consumptionOfWater(), consumptionOfCoffee() и consumptionOfMilk()
	 * реализуют уменьшение запаса ингридиентов в процессе приготовления напитков и
	 * сигнализацию в случае когда ингридиенты закончились
	 */
	public boolean consumptionOfWater(int water) {
		if (levelWater < water) {
			return false;
		}
		levelWater -= water;
		if (levelWater == 0) {
			Show.messageToUser("В машине закончилась вода. Проведите обслуживание!");
		}
		return true;
	}

	public boolean consumptionOfCoffee(int coffee) {
		if (levelCoffee < coffee) {
			return false;
		}
		levelCoffee -= coffee;
		if (levelCoffee == 0) {
			Show.messageToUser("В машине закончилось кофе. Проведите обслуживание!");
		}
		return true;
	}

	public boolean consumptionOfMilk(int milk) {
		if (levelMilk < milk) {
			return false;
		}
		levelMilk -= milk;
		if (levelMilk == 0) {
			Show.messageToUser("В машине закончилось молоко. Проведите обслуживание!");
		}
		return true;
	}

	public int getLevelWater() {
		return levelWater;
	}

	public void setLevelWater(int levelWater) {
		this.levelWater = levelWater;
	}

	public int getLevelCoffee() {
		return levelCoffee;
	}

	public void setLevelCoffee(int levelCoffee) {
		this.levelCoffee = levelCoffee;
	}

	public int getLevelMilk() {
		return levelMilk;
	}

	public void setLevelMilk(int levelMilk) {
		this.levelMilk = levelMilk;
	}

	public String getId() {
		return id;
	}

	public int getSizeOfWater() {
		return sizeOfWater;
	}

	public int getSizeOfCoffee() {
		return sizeOfCoffee;
	}

	public int getSizeOfMilk() {
		return sizeOfMilk;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, levelCoffee, levelMilk, levelWater, sizeOfCoffee, sizeOfMilk, sizeOfWater);
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
				&& levelWater == other.levelWater && sizeOfCoffee == other.sizeOfCoffee
				&& sizeOfMilk == other.sizeOfMilk && sizeOfWater == other.sizeOfWater;
	}

	@Override
	public String toString() {
		return "CoffeeMachina [id=" + id + ", sizeOfWater=" + sizeOfWater + ", sizeOfCoffee=" + sizeOfCoffee
				+ ", sizeOfMilk=" + sizeOfMilk + ", levelWater=" + levelWater + ", levelCoffee=" + levelCoffee
				+ ", levelMilk=" + levelMilk + "]";
	}
}
