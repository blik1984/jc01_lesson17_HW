package com.edu.training.js.cofeeShop.main;

import com.edu.training.js.cofeeShop.entity.CoffeeMachina;
import com.edu.training.js.cofeeShop.entity.CoffeeShop;
import com.edu.training.js.cofeeShop.ui.Show;
import com.edu.training.js.coffeeShop.logic.Logic;

public class Main {

	public static void main(String[] args) {
		
		CoffeeMachina one = new CoffeeMachina("shaitanCoffeevarka",100,100,100,100,100,100);
		CoffeeMachina two = new CoffeeMachina("shaitanCoffeevarka2",100,100,100,100,1,100);
		CoffeeMachina three = new CoffeeMachina("shaitanCoffeevarka3",200,200,200,0,0,0);
		CoffeeShop shop = new CoffeeShop();
		
		shop.add(one);
		shop.add(two);
		shop.add(three);
		
		Logic l = new Logic(new Show(shop));
		
		
	//	Show s = new Show(new Logic(shop));
		
		l.start();

	}

}
