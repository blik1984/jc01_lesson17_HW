package com.edu.training.js.coffeeshop.ui;

import java.util.Scanner;

import com.edu.training.js.coffeeshop.entity.CoffeeMachina;
import com.edu.training.js.coffeeshop.entity.CoffeeShop;
import com.edu.training.js.coffeeshop.entity.CoffeeType;
import com.edu.training.js.coffeeshop.logic.Logic;

public class Show {

	private final Scanner scanner = new Scanner(System.in);
	private final CoffeeShop shop;
	private final Logic logic;

	public Show(Logic logic) {
		this.logic = logic;
		this.shop = logic.getShop();
	}

	/*
	 * Вывод сообщения пользователю
	 */
	public static void messageToUser(String message) {
		System.out.println(message);
	}

	/*
	 * Вывод стартовго меню и получение команды пользователя
	 */
	public void startMenue() {

		boolean flag = false;

		while (!flag) {

			System.out.println("\nВыберите необходимое действие:");
			System.out.println("1) Обслуживание кофейни");
			System.out.println("2) Приготовление напитка");
			System.out.println("3) Закончить работу");
			System.out.println(">>>>>>");

			while (!scanner.hasNextInt()) {
				System.out.println("\nВыберите необходимое действие:");
				System.out.println("1) Обслуживание кофейни");
				System.out.println("2) Приготовление напитка");
				System.out.println("3) Закончить работу");
				System.out.println(">>>>>>");
				scanner.nextLine();
			}

			int answer = Integer.parseInt(scanner.nextLine().trim());

			if (answer == 1) {
				serviceShopMenue();
				continue;
			} else if (answer == 2) {
				makeCoffee();
				continue;
			} else if (answer == 3) {
				System.out.println("Будете у нас на Колыме, заходите ещё!");
				flag = true;
				return;
			}
		}
	}

	public void makeCoffee() {
		CoffeeMachina machina = selectCoffeeMachina();
		CoffeeType coffeeType = selectDrink();
		if (logic.makeCoffee(machina, coffeeType)) {
			System.out.println("Кофе готов!");
		} else {
			System.out.println("Недостаточно ингридиентов, проведисе сервисное обслуживание!");
		}
	}

	/*
	 * Вывод сервисного меню и получение команды пользователя
	 */
	public void serviceShopMenue() {

		boolean flag = false;

		while (!flag) {

			System.out.println("\nСервисное меню");
			System.out.println("Выберите операцию:");
			System.out.println("1) Добавить кофемашину");
			System.out.println("2) Удалить кофемашину");
			System.out.println("3) Загрузка ингридиентов");
			System.out.println("4) Выход в главное меню");
			System.out.println(">>>>>>");

			while (!scanner.hasNextInt()) {
				System.out.println("\nВыберите операцию:");
				System.out.println("1) Добавить кофемашину");
				System.out.println("2) Удалить кофемашину");
				System.out.println("3) Загрузка ингридиентов");
				System.out.println("4) Выход в главное меню");
				System.out.println(">>>>>>");
				scanner.nextLine();
			}
			int answer = Integer.parseInt(scanner.nextLine().trim());

			if (answer == 1) {
				if (addCoffeeMachina()) {
					System.out.println("Кофемашина добавлена");
				} else {
					System.out.println("Произошла ошибка. Проверьте данные и повторите процедуру.");
				}
				continue;
			} else if (answer == 2) {
				if (deleteCoffeeMachina()) {
					System.out.println("Кофемашина удалена");
				} else {
					System.out.println("Произошла ошибка. Проверьте данные и повторите процедуру.");
				}
				continue;
			} else if (answer == 3) {
				replenishment();
				continue;
			} else if (answer == 4) {
				flag = true;
				return;
			}
		}
	}

	public boolean addCoffeeMachina() {

		CoffeeMachina machina = newCoffeeMachina();
		if (logic.addCoffeeMachina(machina)) {
			return true;
		}
		return false;
	}

	public boolean deleteCoffeeMachina() {

		CoffeeMachina machina = selectCoffeeMachina();
		if (logic.deleteCoffeeMachina(machina)) {
			return true;
		}
		return false;
	}

	public void replenishment() {

		CoffeeMachina machina = selectCoffeeMachina();

		System.out.println("Текущие запасы ингридиентов: ");
		showIngredientsLevel(machina);
		System.out.println("\nДелаем сильное колдунство и добавляем ингридиенты!\n");
		logic.replenishment(machina);
		System.out.println("Обновленные запасы ингридиентов: \n");
		showIngredientsLevel(machina);
		System.out.println();

	}

	/*
	 * Метод реализует выбор пользователем активной кофемашины
	 */
	public CoffeeMachina selectCoffeeMachina() {

		Show.messageToUser("Выберите используемую кофемашину");
		System.out.println("Для данной операции доступны следующие кофемашины:");

		for (int i = 1; i <= shop.getCoffeeMachinas().size(); i++) {
			System.out.println(i + ") " + shop.getCoffeeMachinas().get(i - 1).getId());
		}

		System.out.println("\nВведите порядковый номер необходимой машины >>>>");
		boolean flag = false;
		int index = 0;
		while (!scanner.hasNextInt()) {
			System.out.println("\nВвод неверный.");
			System.out.println("Введите порядковый номер необходимой машины >>>>");
			scanner.nextLine();
		}
		while (flag == false) {
			index = Integer.parseInt(scanner.nextLine());
			if (index > 0 && index <= shop.getCoffeeMachinas().size()) {
				flag = true;
			} else {
				selectCoffeeMachina();
			}
		}
		CoffeeMachina machina = shop.getCoffeeMachina(index - 1);
		return machina;
	}

	/*
	 * Метод реализует выбор пользователем напитка для приготвления
	 */
	public CoffeeType selectDrink() {

		boolean flag = false;
		int index = 0;
		System.out.println("\nДля приготвления доступны следующие напитки:\n");
		CoffeeType[] coffee = CoffeeType.values();
		for (CoffeeType c : coffee) {
			System.out.println(c);
		}
		System.out.println("\nВведите порядковый номер необходимого напитка");
		System.out.println(">>>>>>");
		while (!scanner.hasNextInt()) {
			System.out.println("\nВвод неверный.");
			System.out.println("Введите порядковый номер необходимого напитка");
			System.out.println(">>>>>>");
			scanner.nextLine();
		}
		while (flag == false) {
			index = Integer.parseInt(scanner.nextLine().trim());
			if (index > 0 && index <= coffee.length) {
				flag = true;
			} else {
				selectDrink();
			}
		}
		return coffee[index - 1];
	}

	/*
	 * Метод реализует получение от пользователя данных новой кофемашины
	 */
	public CoffeeMachina newCoffeeMachina() {
		String id = getInfoFromUser("Введите название машины");
		int sizeOfWater = getIntegerInfoFromUser("Введите размер бака для воды");
		int sizeOfCoffee = getIntegerInfoFromUser("Введите размер бака для кофе");
		int sizeOfMilk = getIntegerInfoFromUser("Введите размер бака для молока");
		int levelWater = getIntegerInfoFromUser("Введите актуальный уровень воды в баке");
		int levelCoffee = getIntegerInfoFromUser("Введите актуальный уровень кофе в баке");
		int levelMilk = getIntegerInfoFromUser("Введите актуальный уровень молока в баке");

		CoffeeMachina machina = new CoffeeMachina(id, sizeOfWater, sizeOfCoffee, sizeOfMilk, levelWater, levelCoffee,
				levelMilk);
		return machina;
	}

	/*
	 * Метод выводит текущий уровень ингридиентов в кофемашине
	 */
	public void showIngredientsLevel(CoffeeMachina machina) {

		System.out.println("Кофемашина: " + machina.getId());
		System.out.println("Уровень воды: " + machina.getLevelWater() + " из " + machina.getSizeOfWater());
		System.out.println("Уровень воды: " + machina.getLevelWater() + " из " + machina.getSizeOfWater());
		System.out.println("Уровень воды: " + machina.getLevelWater() + " из " + machina.getSizeOfWater());
	}

	/*
	 * Получение от пользователя текстовых данных
	 */
	public String getInfoFromUser(String message) {
		System.out.println(message);
		String s = scanner.nextLine();
		return s;
	}

	/*
	 * Получение от пользователя целочисленных данных
	 */
	public int getIntegerInfoFromUser(String message) {
		System.out.println(message);
		while (!scanner.hasNextInt()) {
			System.out.println(message);
			scanner.nextLine();
		}
		int answer = Integer.parseInt(scanner.nextLine().trim());
//		scanner.nextLine();
		return answer;
	}

	public CoffeeShop getShop() {
		return shop;
	}
}
