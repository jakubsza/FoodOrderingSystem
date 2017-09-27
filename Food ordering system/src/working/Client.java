package working;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import entities.Cuisine;
import entities.Dessert;
import entities.Drinks;
import entities.Foods;
import helpers.ErrorsDealing;
import helpers.Order;
import helpers.QueryHelper;
import helpers.TotalOrder;

public class Client {

	public Client(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	private EntityManager entityManager;

	public void ordering() {
		Scanner dane = new Scanner(System.in);
		double bill = 0.0;

		System.out.println("How many people want to order food?");

		boolean ok = false;
		int result = 0;

		result = ErrorsDealing.getIntNumber();

		TotalOrder totalOrder = new TotalOrder();
		List<Order> orders = new ArrayList<Order>();

		for (int i = 0; i < result; i++) {
			System.out.println("Client number " + (i + 1) + " you can order now.");
			orders = orderingBySinglePerson(orders);
			totalOrder.setSingleOrder(orders);
		}

		totalOrder.displayBill();

	}

	public List<Order> orderingBySinglePerson(List<Order> orders) {
		long cuisine;

		cuisine = choosingCuisine();

		orders = choosingFood(orders, cuisine);
		orders = choosingDrink(orders, cuisine);
		orders = choosingDessert(orders, cuisine);

		return orders;
	}

	private long choosingCuisine() {
		QueryHelper queryHelper = new QueryHelper(entityManager);
		System.out.println("Please select cuisine.");

		// query for cuisine

		List<Cuisine> queryCuisineResults = queryHelper.CuisineQuery("select c from Cuisine c");

		long cuisine = 0;

		for (Cuisine cuisine1 : queryCuisineResults)
			System.out.println(++cuisine + " - " + cuisine1.getName());

		cuisine = ErrorsDealing.getLongNumberCuisine(queryCuisineResults);

		return cuisine;
	}

	private List<Order> choosingFood(List<Order> orders, long cuisine) {
		Order order = new Order();
		QueryHelper queryHelper = new QueryHelper(entityManager);
		List<Foods> queryFoodsResults = queryHelper.FoodQuery("select f from Foods f", cuisine);

		List<Cuisine> queryCuisineResults = queryHelper.CuisineQuery("select c from Cuisine c");

		System.out.println(
				"Please pick food from " + queryCuisineResults.get((int) (cuisine - 1)).getName() + " cuisine.");

		long food = 0;

		for (Foods foods : queryFoodsResults) {
			System.out.println("*********************");
			System.out.println(++food + " - " + foods.getName());
			System.out.println(foods.getDescription());
			System.out.println(foods.getPrice() + " PLN");
		}

		// try-catch for wrong dates
		food = ErrorsDealing.getLongNumberFoods(queryFoodsResults);

		order.setOrder(queryFoodsResults.get((int) (food - 1)).getName());
		order.setPrice(queryFoodsResults.get((int) (food - 1)).getPrice());
		order.setTimes(1);
		orders = updatingOrder(orders, order);

		return orders;
	}

	private List<Order> updatingOrder(List<Order> orders, Order order) {

		if (orders != null) {
			for (Order order2 : orders) {
				if ((order2.getOrder()).equals(order.getOrder())) {
					order2.setTimes(order2.getTimes() + 1);
					return orders;
				}
			}
		}
		orders.add(order);
		return orders;
	}

	private List<Order> choosingDrink(List<Order> orders, long cuisine) {
		Order order = new Order();
		QueryHelper queryHelper = new QueryHelper(entityManager);
		List<Drinks> queryDrinkResults = queryHelper.DrinksQuery("select d from Drinks d");

		long drink = 0;

		System.out.println("0 - nothing to drink");

		for (Drinks drinks : queryDrinkResults) {
			System.out.println("*********************");
			System.out.println(++drink + " - " + drinks.getName());
			System.out.println(drinks.getPrice() + " PLN");
		}

		// try-catch for wrong dates
		drink = ErrorsDealing.getLongNumberDrinks(queryDrinkResults);
		if (drink != 0L) {

			order.setOrder(queryDrinkResults.get((int) (drink - 1)).getName());
			order.setPrice(queryDrinkResults.get((int) (drink - 1)).getPrice());
			order.setTimes(1);
			orders = updatingOrder(orders, order);

			extraQuestionDrinks(queryDrinkResults, drink);
		}

		return orders;
	}

	private void extraQuestionDrinks(List<Drinks> queryDrinkResults, long drink) {
		boolean ok;
		Scanner dane = new Scanner(System.in);

		if (queryDrinkResults.get((int) (drink - 1)).getIceCubes()) {
			System.out.println("Do you want ice cubes for your " + queryDrinkResults.get((int) (drink - 1)).getName()
					+ "? Please answer Y (yes) or N (no).");

			ErrorsDealing.getYesOrNoAnswer();

		}

		if (queryDrinkResults.get((int) (drink - 1)).getLemon()) {
			System.out.println("Do you want lemon for your " + queryDrinkResults.get((int) (drink - 1)).getName()
					+ "? Please answer Y (yes) or N (no).");

			ErrorsDealing.getYesOrNoAnswer();
		}
	}

	private List<Order> choosingDessert(List<Order> orders, long cuisine) {
		Order order = new Order();
		QueryHelper queryHelper = new QueryHelper(entityManager);
		List<Dessert> queryDessertResults = queryHelper.DessertQuery("select d from Dessert d", cuisine);

		List<Cuisine> queryCuisineResults = queryHelper.CuisineQuery("select c from Cuisine c");

		System.out.println(
				"Please pick dessert from " + queryCuisineResults.get((int) (cuisine - 1)).getName() + " cuisine.");

		long dessert = 0;

		System.out.println("0 - nothing for dessert");

		for (Dessert dessert2 : queryDessertResults) {
			System.out.println("*********************");
			System.out.println(++dessert + " - " + dessert2.getName());
			System.out.println(dessert2.getDescription());
			System.out.println(dessert2.getPrice() + " PLN");
		}

		// try-catch for wrong dates
		dessert = ErrorsDealing.getLongNumberDessert(queryDessertResults);

		if (dessert != 0L) {
			order.setOrder(queryDessertResults.get((int) (dessert - 1)).getName());
			order.setPrice(queryDessertResults.get((int) (dessert - 1)).getPrice());
			order.setTimes(1);
			orders = updatingOrder(orders, order);
		}

		return orders;
	}

}
