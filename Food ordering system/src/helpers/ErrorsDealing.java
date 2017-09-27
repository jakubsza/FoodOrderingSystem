package helpers;

import java.util.List;
import java.util.Scanner;

import entities.Cuisine;
import entities.Dessert;
import entities.Drinks;
import entities.Foods;

public class ErrorsDealing {

	public static Long getLongNumberCuisine(List<Cuisine> queryCuisineResults) {
		Scanner dane = new Scanner(System.in);
		Long cuisine;
		while (true) {
			try {
				cuisine = Long.parseLong(dane.nextLine());
				System.out.println("You picked " + queryCuisineResults.get((int) (cuisine - 1)).getName());
				return cuisine;
			} catch (IndexOutOfBoundsException | NumberFormatException e) {
				System.out.println("You picked wrong number, please try again.");
			}
		}
	}

	public static Long getLongNumberFoods(List<Foods> queryFoodResults) {
		Scanner dane = new Scanner(System.in);
		Long food;
		while (true) {
			try {
				food = Long.parseLong(dane.nextLine());
				System.out.println("You picked " + queryFoodResults.get((int) (food - 1)).getName());
				return food;
			} catch (IndexOutOfBoundsException | NumberFormatException e) {
				System.out.println("You picked wrong number, please try again.");
			}
		}
	}

	public static Long getLongNumberDrinks(List<Drinks> queryDrinksResults) {
		Scanner dane = new Scanner(System.in);
		Long drinks;
		while (true) {
			try {
				drinks = Long.parseLong(dane.nextLine());
				if (drinks == 0L) {
					System.out.println("You don't want to drink anything.");
					return drinks;
				} else {
					System.out.println("You picked " + queryDrinksResults.get((int) (drinks - 1)).getName());
					return drinks;
				}

			} catch (IndexOutOfBoundsException | NumberFormatException e) {
				System.out.println("You picked wrong number, please try again.");
			}
		}
	}

	public static Long getLongNumberDessert(List<Dessert> queryDessertResults) {
		Scanner dane = new Scanner(System.in);
		Long dessert;
		while (true) {
			try {
				dessert = Long.parseLong(dane.nextLine());
				if (dessert == 0L) {
					System.out.println("You don't want to eat dessert.");
					return dessert;
				} else {
					System.out.println("You picked " + queryDessertResults.get((int) (dessert - 1)).getName());
					return dessert;
				}

			} catch (IndexOutOfBoundsException | NumberFormatException e) {
				System.out.println("You picked wrong number, please try again.");
			}
		}
	}

	public static int getIntNumber() {
		Scanner dane = new Scanner(System.in);
		int result;
		while (true) {
			try {
				result = Integer.parseInt(dane.next());
				return result;
			} catch (NumberFormatException e) {
				System.out.println("You picked wrong number, please pick correct one.");
			}
		}
	}

	public static double getPrice() {
		Scanner dane = new Scanner(System.in);
		double result;
		while (true) {
			try {
				result = Double.parseDouble(dane.next());
				if (result > 0) {
					return result;
				} else {
					System.out.println("You picked non-positive price, please pick correct one.");
				}
			} catch (NumberFormatException e) {
				System.out.println("You picked wrong number, please pick correct one.");
			}
		}
	}

	public static String getYesOrNoAnswer() {
		Scanner dane = new Scanner(System.in);
		String stringResult;
		while (true) {
			stringResult = dane.next().toString().toUpperCase();
			if (stringResult.equals("Y") || stringResult.equals("N")) {
				return stringResult;
			} else {
				System.out.println("You picked wrong answer, please pick correct one.");
			}
		}
	}

	public static String getIceLemonOrBoth() {
		Scanner dane = new Scanner(System.in);
		String stringResult;
		while (true) {
			stringResult = dane.next().toString().toUpperCase();
			if (stringResult.equals("B") || stringResult.equals("I") || stringResult.equals("L")) {
				return stringResult;
			} else {
				System.out.println("You picked wrong answer, please pick correct one.");
			}
		}
	}
}
