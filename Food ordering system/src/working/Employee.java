package working;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import entities.Cuisine;
import entities.Dessert;
import entities.Drinks;
import entities.Foods;
import helpers.ErrorsDealing;
import helpers.QueryHelper;
import helpers.SqlAdding;

public class Employee {

	public Employee(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	private EntityManager entityManager;

	public void adding() {

		System.out.println("Hi! You would like to add new foods, new drinks, new cuisine or new dessert.");

		addingMenu();
	}

	private void addingMenu() {
		System.out.println("Press below numer:\n" + "1 - if you want to add food\n" + "2 - if you want to add cuisine\n"
				+ "3 - if you want to add drink\n" + "4 - if you want to add dessert");

		boolean ok = false;
		int result = 0;

		// try-catch for wrong dates
		while (!ok) {
			result = ErrorsDealing.getIntNumber();
			if (result == 1 || result == 2 || result == 3 || result == 4) {
				ok = true;
			} else {
				System.out.println("You picked wrong number, please pick correct one.");
			}
		}

		switch (result) {
		case 1:
			addingFood();
			break;
		case 2:
			addingCuisine();
			break;
		case 3:
			addingDrink();
			break;
		case 4:
			addingDessert();
			break;
		}

		System.out.println("Do you want to add anything more? Please answer Y (yes) or N (no).");

		ok = false;
		result = 0;

		String stringResult;

		// try-catch for wrong dates
		stringResult = ErrorsDealing.getYesOrNoAnswer();

		if (stringResult.equals("Y")) {
			addingMenu();
		}
	}

	private void addingFood() {
		QueryHelper queryHelper = new QueryHelper(entityManager);
		Scanner dane = new Scanner(System.in);
		String name, description;
		double price = 0.0;
		Cuisine cuisine;

		System.out.println("Please pick cuisine for your food.");

		// query for cuisine
		List<Cuisine> queryCuisineResults = queryHelper.CuisineQuery("select c from Cuisine c");

		long number = 0;

		for (Cuisine cuisine1 : queryCuisineResults)
			System.out.println(++number + " - " + cuisine1.getName());

		// try-catch for wrong dates
		number = ErrorsDealing.getLongNumberCuisine(queryCuisineResults);

		// setting up cuisine from SQL (very important!!!)
		cuisine = entityManager.find(Cuisine.class, number);

		// adding new name
		System.out.println("Please write food name");
		name = dane.nextLine();

		System.out.println("Please write food description");
		description = dane.nextLine();

		System.out.println("Please write food price");

		// try-catch for wrong dates
		price = ErrorsDealing.getPrice();

		// updating SQL
		SqlAdding sqlAdding = new SqlAdding(entityManager);
		sqlAdding.addingToSQL(new Foods(name, description, price, cuisine));

	}

	private void addingDrink() {
		QueryHelper queryHelper = new QueryHelper(entityManager);
		Scanner dane = new Scanner(System.in);
		String name;
		double price = 0.0;

		System.out.println("Please write drink name");
		name = dane.nextLine();

		System.out.println("Please write drink price");

		// try-catch for wrong dates
		price = ErrorsDealing.getPrice();

		System.out.println(
				"Can we offer this drink with ice cubes or/and lemon? Please answer I (ice cubes), L (lemon), or B (both).");

		String stringResult;

		// try-catch for wrong dates
		stringResult = ErrorsDealing.getIceLemonOrBoth();

		boolean iceCubes = false;
		boolean lemon = false;

		if (stringResult.equals("I") || stringResult.equals("B")) {
			iceCubes = true;
		}
		if (stringResult.equals("L") || stringResult.equals("B")) {
			lemon = true;
		}

		// updating SQL for drinks
		SqlAdding sqlAdding = new SqlAdding(entityManager);
		sqlAdding.addingToSQL(new Drinks(name, price, iceCubes, lemon));

	}

	private void addingCuisine() {
		QueryHelper queryHelper = new QueryHelper(entityManager);
		Scanner dane = new Scanner(System.in);
		String name;

		System.out.println("Please write cuisine name");
		name = dane.nextLine();

		// updating SQL for cuisine
		SqlAdding sqlAdding = new SqlAdding(entityManager);
		sqlAdding.addingToSQL(new Cuisine(name));

	}

	private void addingDessert() {
		QueryHelper queryHelper = new QueryHelper(entityManager);
		Scanner dane = new Scanner(System.in);
		String name, description;
		double price = 0.0;
		Cuisine cuisine;

		System.out.println("Please pick cuisine for your dessert.");

		// query for cuisine
		List<Cuisine> queryCuisineResults = queryHelper.CuisineQuery("select c from Cuisine c");

		long number = 0;

		for (Cuisine cuisine1 : queryCuisineResults)
			System.out.println(++number + " - " + cuisine1.getName());

		number = ErrorsDealing.getLongNumberCuisine(queryCuisineResults);

		// setting up cuisine from SQL (very important!!!)
		cuisine = entityManager.find(Cuisine.class, number);

		System.out.println("Please write dessert name");
		name = dane.nextLine();

		System.out.println("Please write dessert description");
		description = dane.nextLine();

		System.out.println("Please write food price");

		// try-catch for wrong dates
		price = ErrorsDealing.getPrice();

		// updating SQL for dessert
		SqlAdding sqlAdding = new SqlAdding(entityManager);
		sqlAdding.addingToSQL(new Dessert(name, description, price, cuisine));

	}

}
