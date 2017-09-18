package entities;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class Employee {

	public Employee(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	private EntityManager entityManager;

	public void adding() {
		Scanner dane;

		System.out.println("Hi! You would like to add new foods, new drinks, new cuisine or new dessert.\n"
				+ "Press below numer:\n" + "1 - if you want to add food\n" + "2 - if you want to add cuisine\n"
				+ "3 - if you want to add drink\n" + "4 - if you want to add dessert");

		dane = new Scanner(System.in);

		boolean ok = false;
		int result = 0;

		// try-catch for wrong dates
		while (!ok) {
			try {
				result = Integer.parseInt(dane.next());
			} catch (NumberFormatException e) {
				System.out.println("You picked wrong number, please pick correct one.");
				continue;
			}
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

		String stringResult = "";

		// try-catch for wrong dates
		while (!ok) {
			stringResult = dane.next().toString().toUpperCase();
			if (stringResult.equals("Y") || stringResult.equals("N")) {
				ok = true;
				break;
			} else {
				System.out.println("You picked wrong answer, please pick correct one.");
			}
		}

		if (stringResult.equals("Y")) {
			addingAgain();
		}
	}

	public void addingAgain() {
		Scanner dane;

		System.out.println("Press below numer:\n" + "1 - if you want to add food\n" + "2 - if you want to add cuisine\n"
				+ "3 - if you want to add drink\n" + "4 - if you want to add dessert");

		dane = new Scanner(System.in);

		boolean ok = false;
		int result = 0;

		// try-catch for wrong dates
		while (!ok) {
			try {
				result = Integer.parseInt(dane.next());
			} catch (NumberFormatException e) {
				System.out.println("You picked wrong number, please pick correct one.");
				continue;
			}
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

		String stringResult = "";

		// try-catch for wrong dates
		while (!ok) {
			stringResult = dane.next().toString().toUpperCase();
			if (stringResult.equals("Y") || stringResult.equals("N")) {
				ok = true;
				break;
			} else {
				System.out.println("You picked wrong answer, please pick correct one.");
			}
		}

		if (stringResult.equals("Y")) {
			addingAgain();
		}
	}

	public void addingFood() {
		Scanner dane = new Scanner(System.in);
		String name, description;
		double price = 0.0;
		Cuisine cuisine;

		System.out.println("Please pick cuisine for your food.");

		// query for cuisine
		TypedQuery<Cuisine> query = entityManager.createQuery("select c from Cuisine c", Cuisine.class);
		List<Cuisine> queryResults = query.getResultList();

		long i = 0;

		for (Cuisine cuisine1 : queryResults)
			System.out.println(++i + " - " + cuisine1.getName());

		boolean ok = false;

		// try-catch for wrong dates
		while (!ok) {
			try {
				i = Long.parseLong(dane.nextLine());
				try {
					System.out.println("You picked " + queryResults.get((int) (i - 1)).getName());
					ok = true;
				} catch (IndexOutOfBoundsException e) {
					System.out.println("You picked wrong number, please try again.");
					continue;
				}
				ok = true;
			} catch (NumberFormatException e) {
				System.out.println("You picked wrong number, please try again.");
				continue;
			}
		}

		// setting up cuisine from SQL (very important!!!)
		cuisine = entityManager.find(Cuisine.class, i);

		// adding new name
		System.out.println("Please write food name");
		name = dane.nextLine();

		System.out.println("Please write food description");
		description = dane.nextLine();

		ok = false;

		System.out.println("Please write food price");

		// try-catch for wrong dates
		while (!ok) {
			try {
				price = Double.parseDouble(dane.next());
			} catch (NumberFormatException e) {
				System.out.println("You picked wrong number, please pick correct one.");
				continue;
			}
			if (price > 0) {
				ok = true;
			} else {
				System.out.println("You picked non-positive price, please pick correct one.");
			}
		}

		// updating SQL
		addingFoodToSQL(new Foods(name, description, price, cuisine));

	}

	public void addingDrink() {
		Scanner dane = new Scanner(System.in);
		String name;
		double price = 0.0;

		System.out.println("Please write drink name");
		name = dane.nextLine();

		boolean ok = false;

		System.out.println("Please write drink price");

		// try-catch for wrong dates
		while (!ok) {
			try {
				price = Double.parseDouble(dane.next());
			} catch (NumberFormatException e) {
				System.out.println("You picked wrong number, please pick correct one.");
				continue;
			}
			if (price > 0) {
				ok = true;
			} else {
				System.out.println("You picked non-positive price, please pick correct one.");
			}
		}

		System.out.println(
				"Can we offer this drink with ice cubes or/and lemon? Please answer I (ice cubes), L (lemon), or B (both).");

		ok = false;

		String stringResult = "";

		// try-catch for wrong dates
		while (!ok) {
			stringResult = dane.next().toString().toUpperCase();
			if (stringResult.equals("B") || stringResult.equals("I") || stringResult.equals("L")) {
				ok = true;
				break;
			} else {
				System.out.println("You picked wrong answer, please pick correct one.");
			}
		}

		boolean iceCubes = false;
		boolean lemon = false;

		if (stringResult.equals("I") || stringResult.equals("B")) {
			iceCubes = true;
		}
		if (stringResult.equals("L") || stringResult.equals("B")) {
			lemon = true;
		}

		// updating SQL for drinks
		addingDrinkToSQL(new Drinks(name, price, iceCubes, lemon));

	}

	public void addingCuisine() {
		Scanner dane = new Scanner(System.in);
		String name;

		System.out.println("Please write cuisine name");
		name = dane.nextLine();

		// updating SQL for cuisine
		addingCuisineToSQL(new Cuisine(name));

	}

	public void addingDessert() {
		Scanner dane = new Scanner(System.in);
		String name, description;
		double price = 0.0;
		Cuisine cuisine;

		System.out.println("Please pick cuisine for your dessert.");

		// query for cuisine
		TypedQuery<Cuisine> query = entityManager.createQuery("select c from Cuisine c", Cuisine.class);
		List<Cuisine> queryResults = query.getResultList();

		long i = 0;

		for (Cuisine cuisine1 : queryResults)
			System.out.println(++i + " - " + cuisine1.getName());

		boolean ok = false;

		// try-catch for wrong dates
		while (!ok) {
			try {
				i = Long.parseLong(dane.nextLine());
				try {
					System.out.println("You picked " + queryResults.get((int) (i - 1)).getName());
					ok = true;
				} catch (IndexOutOfBoundsException e) {
					System.out.println("You picked wrong number, please try again.");
					continue;
				}
				ok = true;
			} catch (NumberFormatException e) {
				System.out.println("You picked wrong number, please try again.");
				continue;
			}
		}

		// setting up cuisine from SQL (very important!!!)
		cuisine = entityManager.find(Cuisine.class, i);

		System.out.println("Please write dessert name");
		name = dane.nextLine();

		System.out.println("Please write dessert description");
		description = dane.nextLine();

		ok = false;

		System.out.println("Please write food price");

		// try-catch for wrong dates
		while (!ok) {
			try {
				price = Double.parseDouble(dane.next());
			} catch (NumberFormatException e) {
				System.out.println("You picked wrong number, please pick correct one.");
				continue;
			}
			if (price > 0) {
				ok = true;
			} else {
				System.out.println("You picked non-positive price, please pick correct one.");
			}
		}

		// updating SQL for dessert
		addingDessertToSQL(new Dessert(name, description, price, cuisine));

	}

	public void addingFoodToSQL(Foods food) {
		entityManager.getTransaction().begin();
		entityManager.persist(food);
		entityManager.getTransaction().commit();
	}

	public void addingCuisineToSQL(Cuisine cuisine) {
		entityManager.getTransaction().begin();
		entityManager.persist(cuisine);
		entityManager.getTransaction().commit();
	}

	public void addingDrinkToSQL(Drinks drink) {
		entityManager.getTransaction().begin();
		entityManager.persist(drink);
		entityManager.getTransaction().commit();
	}

	public void addingDessertToSQL(Dessert dessert) {
		entityManager.getTransaction().begin();
		entityManager.persist(dessert);
		entityManager.getTransaction().commit();
	}
}
