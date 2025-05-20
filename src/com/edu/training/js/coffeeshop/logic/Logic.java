package com.edu.training.js.coffeeshop.logic;

import com.edu.training.js.coffeeshop.entity.CoffeeMachina;
import com.edu.training.js.coffeeshop.entity.CoffeeShop;
import com.edu.training.js.coffeeshop.entity.CoffeeType;
import com.edu.training.js.coffeeshop.entity.Drink;

public class Logic {

	private final CoffeeShop shop;

	public Logic(CoffeeShop shop) {
		this.shop = shop;
	}

	/*
	 * Метод запускает приготовление напитка
	 */
	public boolean makeCoffee(CoffeeMachina machina, CoffeeType coffeeType) {

		if (machina.checkEnoughIngredients(coffeeType)) {
			Drink drink = machina.makeDrink(coffeeType);
			machina.consumptionOfWater(coffeeType.getWater());
			machina.consumptionOfCoffee(coffeeType.getCoffee());
			machina.consumptionOfMilk(coffeeType.getMilk());
			return true;
		}
		return false;
	}

	/*
	 * Метод пополняет запасы ингридиентов до максимального уровня
	 */
	public void replenishment(CoffeeMachina machina) {
		machina.addWater();
		machina.addCoffee();
		machina.addMilk();
	}

	/*
	 * Метод добавляет новую кофемашину в кофейню
	 */
	public boolean addCoffeeMachina(CoffeeMachina machina) {
		if (checkNewCoffeeMachina(machina)) {
			shop.add(machina);
			return true;
		}
		return false;
	}

	/*
	 * Метод удаляет выбранную кофемашину из кофейни
	 */
	public boolean deleteCoffeeMachina(CoffeeMachina machina) {
		if (shop.getCoffeeMachinas().remove(machina)) {
			return true;
		}
		return false;
	}

	public boolean checkIngredientsLevel(CoffeeMachina m) {

		if (!checkWaterLevel(m) || checkCoffeeLevel(m) || !checkMilkLevel(m)) {
			return false;
		}
		return true;
	}

	public boolean checkWaterLevel(CoffeeMachina m) {
		if (m.getLevelWater() <= 0) {
			return false;
		}
		return true;
	}

	public boolean checkCoffeeLevel(CoffeeMachina m) {
		if (m.getLevelCoffee() <= 0) {
			return false;
		}
		return true;

	}

	public boolean checkMilkLevel(CoffeeMachina m) {
		if (m.getLevelMilk() <= 0) {
			return false;
		}
		return true;
	}

	/*
	 * Метод проверяет вновь созданную кофемашину на корректность технических данных
	 */
	public boolean checkNewCoffeeMachina(CoffeeMachina m) {

		if (m.getLevelWater() > m.getSizeOfWater() || m.getLevelCoffee() > m.getSizeOfCoffee()
				|| m.getLevelMilk() > m.getSizeOfMilk() || m.getSizeOfWater() <= 0 || m.getSizeOfCoffee() <= 0
				|| m.getSizeOfMilk() <= 0 || m.getLevelWater() < 0 || m.getLevelCoffee() < 0 || m.getLevelMilk() < 0) {
			return false;
		}
		return true;
	}

	public CoffeeShop getShop() {
		return shop;
	}
}
