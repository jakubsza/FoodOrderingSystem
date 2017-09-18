package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class Client {

	public Client(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	private EntityManager entityManager;
	private List<String> order;
	private List<Integer> times;
	private List<Double> price;

	public void ordering() {
		Scanner dane = new Scanner(System.in);
		double bill = 0.0;
		order = new ArrayList<String>();
		times = new ArrayList<Integer>();
		price = new ArrayList<Double>();

		System.out.println("How many people want to order food?");

		boolean ok = false;
		int result = 0;

		// try-catch for wrong dates
		while (!ok) {
			try {
				result = Integer.parseInt(dane.next());
				ok = true;
			} catch (NumberFormatException e) {
				System.out.println("You picked wrong number, please pick correct one.");
				continue;
			}
		}

		for (int i = 0; i < result; i++) {
			System.out.println("Client number " + (i + 1) + " you can order now.");
			bill += orderingBySinglePerson();
		}

		System.out.println("Please see your bill:");

		String format = "%-70s%s%n";
		for (int i = 0; i < order.size(); i++) {
			System.out.printf(format, order.get(i) + " x" + times.get(i), price.get(i) + " PLN");
		}
		System.out.println("********************************************************************************");
		System.out.printf(format, "Total price: ", bill + " PLN");
	}

	public double orderingBySinglePerson() {
		double bill = 0.0;
		Scanner dane = new Scanner(System.in);
		System.out.println("Please select cuisine.");

		// query for cuisine
		TypedQuery<Cuisine> queryCuisine = entityManager.createQuery("select c from Cuisine c", Cuisine.class);
		List<Cuisine> queryCuisineResults = queryCuisine.getResultList();

		long cuisine = 0;

		for (Cuisine cuisine1 : queryCuisineResults)
			System.out.println(++cuisine + " - " + cuisine1.getName());

		boolean ok = false;

		// try-catch for wrong dates
		while (!ok) {
			try {
				cuisine = Long.parseLong(dane.nextLine());
				try {
					System.out.println("You picked " + queryCuisineResults.get((int) (cuisine - 1)).getName());
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

		System.out.println(
				"Please pick food from " + queryCuisineResults.get((int) (cuisine - 1)).getName() + " cuisine.");

		// query for food from menu
		TypedQuery<Foods> queryFoods = entityManager.createQuery("select f from Foods f where cuisineID = ?1",
				Foods.class);
		queryFoods.setParameter(1, cuisine);
		List<Foods> queryFoodsResults = queryFoods.getResultList();

		long i = 0;

		for (Foods foods : queryFoodsResults) {
			System.out.println("*********************");
			System.out.println(++i + " - " + foods.getName());
			System.out.println(foods.getDescription());
			System.out.println(foods.getPrice() + " PLN");
		}
		ok = false;

		// try-catch for wrong dates
		while (!ok) {
			try {
				i = Long.parseLong(dane.nextLine());
				try {
					System.out.println("You picked " + queryFoodsResults.get((int) (i - 1)).getName());
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

		bill += queryFoodsResults.get((int) (i - 1)).getPrice();

		if (order != null && order.contains(queryFoodsResults.get((int) (i - 1)).getName())) {
			int index = order.indexOf(queryFoodsResults.get((int) (i - 1)).getName());
			times.set(index, times.get(index) + 1);
			price.set(index, price.get(index) + queryFoodsResults.get((int) (i - 1)).getPrice());
		} else {
			order.add(queryFoodsResults.get((int) (i - 1)).getName());
			times.add(1);
			price.add(queryFoodsResults.get((int) (i - 1)).getPrice());
		}

		System.out.println("Please pick drink.");

		// query for drinks from menu
		TypedQuery<Drinks> queryDrink = entityManager.createQuery("select d from Drinks d", Drinks.class);
		List<Drinks> queryDrinkResults = queryDrink.getResultList();

		i = 0;

		System.out.println("0 - nothing to drink");

		for (Drinks drink : queryDrinkResults) {
			System.out.println("*********************");
			System.out.println(++i + " - " + drink.getName());
			System.out.println(drink.getPrice() + " PLN");
		}
		ok = false;

		// try-catch for wrong dates
		while (!ok) {
			try {
				i = Long.parseLong(dane.nextLine());
				try {
					if (i == 0L) {
						System.out.println("You don't want to drink anything.");
					} else {
						System.out.println("You picked " + queryDrinkResults.get((int) (i - 1)).getName());
					}
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

		if (i > 0L) {
			if (queryDrinkResults.get((int) (i - 1)).getIceCubes()) {
				System.out.println("Do you want ice cubes for your " + queryDrinkResults.get((int) (i - 1)).getName()
						+ "? Please answer Y (yes) or N (no).");

				ok = false;
				int result = 0;

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
			}

			if (queryDrinkResults.get((int) (i - 1)).getLemon()) {
				System.out.println("Do you want lemon for your " + queryDrinkResults.get((int) (i - 1)).getName()
						+ "? Please answer Y (yes) or N (no).");

				ok = false;
				int result = 0;

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
			}

			bill += queryDrinkResults.get((int) (i - 1)).getPrice();

			if (order != null && order.contains(queryDrinkResults.get((int) (i - 1)).getName())) {
				int index = order.indexOf(queryDrinkResults.get((int) (i - 1)).getName());
				times.set(index, times.get(index) + 1);
				price.set(index, price.get(index) + queryDrinkResults.get((int) (i - 1)).getPrice());
			} else {
				order.add(queryDrinkResults.get((int) (i - 1)).getName());
				times.add(1);
				price.add(queryDrinkResults.get((int) (i - 1)).getPrice());
			}
		}

		System.out.println(
				"Please pick dessert from " + queryCuisineResults.get((int) (cuisine - 1)).getName() + " cuisine.");

		// query for dessert from menu
		TypedQuery<Dessert> queryDessert = entityManager.createQuery("select d from Dessert d where cuisineID = ?1",
				Dessert.class);
		queryDessert.setParameter(1, cuisine);
		List<Dessert> queryDessertResults = queryDessert.getResultList();

		i = 0;

		System.out.println("0 - nothing for dessert");

		for (Dessert dessert : queryDessertResults) {
			System.out.println("*********************");
			System.out.println(++i + " - " + dessert.getName());
			System.out.println(dessert.getDescription());
			System.out.println(dessert.getPrice() + " PLN");
		}
		ok = false;

		// try-catch for wrong dates
		while (!ok) {
			try {
				i = Long.parseLong(dane.nextLine());
				try {
					if (i == 0L) {
						System.out.println("You don't want to eat dessert.");
					} else {
						System.out.println("You picked " + queryDessertResults.get((int) (i - 1)).getName());
					}
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
		if (i > 0L) {
			bill += queryDessertResults.get((int) (i - 1)).getPrice();

			if (order != null && order.contains(queryDessertResults.get((int) (i - 1)).getName())) {
				int index = order.indexOf(queryDessertResults.get((int) (i - 1)).getName());
				times.set(index, times.get(index) + 1);
				price.set(index, price.get(index) + queryDessertResults.get((int) (i - 1)).getPrice());
			} else {
				order.add(queryDessertResults.get((int) (i - 1)).getName());
				times.add(1);
				price.add(queryDessertResults.get((int) (i - 1)).getPrice());
			}
		}

		return bill;

	}

}
