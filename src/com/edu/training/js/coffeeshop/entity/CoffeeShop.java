package com.edu.training.js.coffeeshop.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CoffeeShop {

	private List<CoffeeMachina> coffeeMachinas = new ArrayList<>();

	public CoffeeShop() {

	}

	public CoffeeShop(List<CoffeeMachina> coffeeMachinas) {
		this.coffeeMachinas = coffeeMachinas;
	}

	public void add(CoffeeMachina m) {
		coffeeMachinas.add(m);
	}

	public void delete(CoffeeMachina m) {
		coffeeMachinas.remove(coffeeMachinas.indexOf(m));
	}

	public CoffeeMachina getCoffeeMachina(int index) {
		return coffeeMachinas.get(index);
	}

	public List<CoffeeMachina> getCoffeeMachinas() {
		return coffeeMachinas;
	}

	public void setCoffeeMachinas(List<CoffeeMachina> coffeeMachinas) {
		this.coffeeMachinas = coffeeMachinas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(coffeeMachinas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CoffeeShop other = (CoffeeShop) obj;
		return Objects.equals(coffeeMachinas, other.coffeeMachinas);
	}

	@Override
	public String toString() {
		return "CoffeeShop [coffeeMachinas=" + coffeeMachinas + "]";
	}

}
