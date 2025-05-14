package com.edu.training.js.coffeeShop.logic;

import com.edu.training.js.cofeeShop.entity.Coffee;
import com.edu.training.js.cofeeShop.entity.CoffeeMachina;
import com.edu.training.js.cofeeShop.entity.CoffeeShop;
import com.edu.training.js.cofeeShop.ui.Show;

public class Logic {

	private final CoffeeShop shop;
	private final Show show;

	public Logic(Show show) {
		this.shop = show.getShop();
		this.show = show;
	}

	/*
	 * Метод реализует стартове меню кофейни
	 */
	public void start() {

		boolean flag = false;
		while (!flag) {
			int answer = show.startMenue();
			if (answer == 1) {
				flag = true;
				serviceShop();
				return;
			} else if (answer == 2) {
				flag = true;
				makeCoffee();
				return;
			} else if (answer == 3) {
				Show.messageToUser("Будете у нас на Колыме, заходите ещё!");
				flag = true;
			}
		}
	}

	/*
	 * Метод рализует сервисное меню кофейни
	 */
	public void serviceShop() {

		int answer = show.serviceShopMenue();
		boolean flag = false;

		while (!flag) {
			if (answer == 1) {
				flag = true;
				addCoffeeMachina();
				return;
			} else if (answer == 2) {
				flag = true;
				deleteCoffeeMachina();
				return;
			} else if (answer == 3) {
				flag = true;
				replenishment();
				return;
			} else if (answer == 4) {
				flag = true;
				start();
			} else {
				serviceShop();
			}
		}
	}

	/*
	 * Метод запускает приготовление напитка
	 */
	public void makeCoffee() {

		Show.messageToUser("Выберите используемую кофемашину:");
		CoffeeMachina machina = show.selectCoffeeMachina();
		Coffee coffee = show.selectDrink();
		if (!machina.makeDrink(coffee)) {
			Show.messageToUser(
					"В Выбранной машине недостаточно ингридиентов. Проведите обслуживание машины или выберите другую машину");
			start();
		} else {
			start();
		}
	}

	/*
	 * Метод пополняет запасы ингридиентов до максимального уровня
	 */
	public void replenishment() {

		CoffeeMachina machina = show.selectCoffeeMachina();

		System.out.println("Текущие запасы ингридиентов: ");
		show.showIngredientsLevel(machina);
		System.out.println("\nДелаем сильное колдунство и добавляем ингридиенты!\n");

		machina.addWater();
		machina.addCoffee();
		machina.addMilk();

		System.out.println("Обновленные запасы ингридиентов: \n");
		show.showIngredientsLevel(machina);
		System.out.println();

		serviceShop();
	}

	/*
	 * Метод добавляет новую кофемашину в кофейню
	 */
	public void addCoffeeMachina() {
		CoffeeMachina machina = show.newCoffeeMacina();
		if (checkNewCoffeeMachina(machina)) {
			shop.add(machina);
			Show.messageToUser("Кофемашина добавлена");
		} else {
			Show.messageToUser("Данные кофемашины некорректны. Кофемашина не добавлена. Повторите операцию.\n");
		}
		serviceShop();
	}

	/*
	 * Метод удаляет выбранную кофемашину из кофейни
	 */
	public void deleteCoffeeMachina() {
		shop.getCoffeeMachinas().remove(show.selectCoffeeMachina());
		Show.messageToUser("Кофемашина удалена \n");

		serviceShop();
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
