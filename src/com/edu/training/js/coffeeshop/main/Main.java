package com.edu.training.js.coffeeshop.main;

import com.edu.training.js.coffeeshop.ui.Show;
import com.edu.training.js.coffeeshop.entity.CoffeeMachina;
import com.edu.training.js.coffeeshop.entity.CoffeeShop;
import com.edu.training.js.coffeeshop.logic.Logic;

public class Main {

	public static void main(String[] args) {
		
		CoffeeMachina one = new CoffeeMachina("shaitanCoffeevarka",100,100,100,100,100,100);
		CoffeeMachina two = new CoffeeMachina("shaitanCoffeevarka2",100,100,100,100,1,100);
		CoffeeMachina three = new CoffeeMachina("shaitanCoffeevarka3",200,200,200,0,0,0);
		CoffeeShop shop = new CoffeeShop();
		
		shop.add(one);
		shop.add(two);
		shop.add(three);
		
		Show s = new Show(new Logic(shop));
		
		s.startMenue();

	}

}
