package com.edu.training.js.cofeeShop.entity;

/*
 * Храним рецепты
 */

public enum Coffee {

	AMERICANO {
		public int[] getComposition() {
			int water = 2;
			int coffee = 1;
			int milk = 0;
			int[] composition = { water, coffee, milk };
			return composition;
		}
	},
	ESPRESSO {
		public int[] getComposition() {
			int water = 1;
			int coffee = 1;
			int milk = 0;
			int[] composition = { water, coffee, milk };
			return composition;
		}
	},
	LATTE {
		public int[] getComposition() {
			int water = 1;
			int coffee = 1;
			int milk = 1;
			int[] composition = { water, coffee, milk };
			return composition;
		}
	};

	public abstract int[] getComposition();
}
