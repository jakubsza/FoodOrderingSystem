package domain;

import javax.persistence.EntityManager;

import entities.Cuisine;
import entities.Dessert;
import entities.Drinks;
import entities.Foods;

public class Menu {

	public Menu(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	private EntityManager entityManager;

	public void createMenu() {

		Cuisine cuisinePL = new Cuisine("Polish");
		Cuisine cuisineMX = new Cuisine("Mexican");
		Cuisine cuisineIT = new Cuisine("Italian");

		Foods foodPL1 = new Foods("Bigos", "stew of sauerkraut and meat, mainly kielbasa", 10, cuisinePL);
		Foods foodPL2 = new Foods("Golonka, Ziemniaki Gotowane, Surówka z Marchewki",
				"stewed pork knuckle or hock, " + "simple boiled potatoes sprinkled with parsley, "
						+ "Polish carrot salad made with 5 peeled and coarsely grated large carrots, 1 peeled, cored and coarsely grated large granny smith apple, juice of ½ lemon, sunflower or vegetable oil, salt, sugar",
				10, cuisinePL);
		Foods foodPL3 = new Foods("Karkówka, Tłuczone Ziemniaki, Mizeria",
				"tenderloin, usually roasted, mashed potatoes, mizeria is traditional Polish salad made from cucumbers in sour cream with dill",
				15, cuisinePL);
		Foods foodPL4 = new Foods("Kiełbasa",
				"sausage is a staple of Polish cuisine and comes in dozens of varieties, smoked, made with pork, beef, turkey, lamb, veal with every region having its own specialty",
				10, cuisinePL);
		Foods foodPL5 = new Foods("Kotlet mielony, Ziemniaki Gotowane, Surówka z Marchewki",
				"minced meat with eggs, bread crumbs, garlic, and salt and pepper rolled into a ball and fried on onion butter, "
						+ "simple boiled potatoes sprinkled with parsley, "
						+ "Polish carrot salad made with 5 peeled and coarsely grated large carrots, 1 peeled, cored and coarsely grated large granny smith apple, juice of ½ lemon, sunflower or vegetable oil, salt, sugar",
				16, cuisinePL);
		Foods foodPL6 = new Foods("Kotlet schabowy, Tłuczone Ziemniaki, Ogórek Kiszony",
				"Polish variety of pork cutlet coated with breadcrumbs made of pork tenderloin (with the bone), mshed potatoes, Polish pickled cucumber",
				18, cuisinePL);
		Foods foodPL7 = new Foods("Kurczak Pieczony, Kasza gryczana, Mizeria",
				"roasted chicken, cooked buckwheat groats, mizeria is traditional Polish salad made from cucumbers in sour cream with dill",
				20, cuisinePL);
		Foods foodPL8 = new Foods("Pierogi", "dumplings, usually filled with sweet curd cheese with a touch of vanilla",
				12, cuisinePL);
		Foods foodPL9 = new Foods("Zrazy zawijane, Kasza gryczana, Buraczki",
				"beef rolls stuffed with bacon, gherkin and onion, cooked buckwheat groats, finely chopped warm beet root salad",
				18, cuisinePL);
		Foods foodPL10 = new Foods("Żeberka wędzone, Tłuczone Ziemniaki, Kapusta Zasmażana",
				"smoked, grilled Ribs, mashed potatoes, sauerkraut pan-fried with fried onions, cooked pork, whole pepper, and rich spices makes for a truly hearty side dish",
				20, cuisinePL);

		Dessert dessertPL1 = new Dessert("Makowiec", "sweet poppy-seed swirl cake, with raisins and walnuts", 3.50,
				cuisinePL);
		Dessert dessertPL2 = new Dessert("Sernik", "cheesecake", 4.20, cuisinePL);
		Dessert dessertPL3 = new Dessert("Kremówka",
				"Polish type of cream pie made of two layers of puff pastry, filled with cream, usually sprinkled with powdered sugar",
				3.80, cuisinePL);

		Dessert dessertMX1 = new Dessert("Arroz con leche", "rice pudding", 5.10, cuisineMX);
		Dessert dessertMX2 = new Dessert("Bionico", "fruit salad with cream", 3.95, cuisineMX);
		Dessert dessertMX3 = new Dessert("Pastel de tres leches ", "Three Milk Cake", 6.20, cuisineMX);

		Dessert dessertIT1 = new Dessert("Buccellato", "a Sicilian circular cake", 4.15, cuisineIT);
		Dessert dessertIT2 = new Dessert("Piccoli Frutti", "small garden fruits", 2.80, cuisineIT);
		Dessert dessertIT3 = new Dessert("Panna cotta",
				"an Italian dessert of sweetened cream thickened with gelatin and molded", 3, cuisineIT);

		Foods foodMX1 = new Foods("Albóndigas", "Mexican meatballs", 15, cuisineMX);
		Foods foodMX2 = new Foods("Carne asada", "grilled beef", 18, cuisineMX);
		Foods foodMX3 = new Foods("Carne a la tampiqueña",
				"carne asada that is usually accompanied by a small portion of enchiladas, refried beans, fresh cheese, guacamole, and a vegetable",
				25, cuisineMX);
		Foods foodMX4 = new Foods("Milanesas", "chicken, beef, and a pork breaded fried bisteces", 19, cuisineMX);
		Foods foodMX5 = new Foods("Birria", "a spicy stew from the state of Jalisco traditionally made from goat meat",
				16, cuisineMX);
		Foods foodMX6 = new Foods("Chapulines", "toasted grasshoppers seasoned with salt and lime", 12, cuisineMX);
		Foods foodMX7 = new Foods("Queso de Puerco",
				"head cheese prepared with vinegar, garlic, oregano and black pepper", 8, cuisineMX);
		Foods foodMX8 = new Foods("Cuitlacoche", " a fungus that grows on corn plants, served in soups", 10, cuisineMX);
		Foods foodMX9 = new Foods("Pipian", "red, meat, pork", 11, cuisineMX);
		Foods foodMX10 = new Foods("Arroz con pollo ", "rice with chicken", 8, cuisineMX);

		Foods foodIT1 = new Foods("Ai frutti di Mare", "seafood pizza that may be served with scampi, mussels", 10,
				cuisineIT);
		Foods foodIT2 = new Foods("Pizza Margherita", "tomato and mozzarella", 7, cuisineIT);
		Foods foodIT3 = new Foods("Calzone", "folded over dough usually filled with ricotta and other ingredients", 12,
				cuisineIT);
		Foods foodIT4 = new Foods("Pizza capricciosa",
				"with tomato, mozzarella, mushrooms, artichokes, black and green olives", 11, cuisineIT);
		Foods foodIT5 = new Foods("Pizza siciliana", "tomato, mozzarella, capperi, olive and anchovy", 11, cuisineIT);
		Foods foodIT6 = new Foods("Lagane e cicciari",
				"prepared with Lagane, a wide pasta with chickpeas, garlic, and oil", 13, cuisineIT);
		Foods foodIT7 = new Foods("Penne all’arrabbiata",
				"Penne pasta, with the arrabbiata sauce, a spicy sauce made from garlic, tomato, and red chili peppers cooked in olive oil ",
				12, cuisineIT);
		Foods foodIT8 = new Foods("Spaghetti alla puttanesca",
				"spaghetti pasta, with a tomato sauce, with anchovies, olives, capers and garlic", 11, cuisineIT);
		Foods foodIT9 = new Foods("Spaghetti alla carbonara",
				"spaghetti pasta, with raw eggs, Pecorino Romano cheese, bacon, and black pepper", 15, cuisineIT);
		Foods foodIT10 = new Foods("Timballo", "a baked pasta dish, made with cheese, meat and vegetables", 12,
				cuisineIT);

		Drinks drink1 = new Drinks("Water 0.3L", 3, true, true);
		Drinks drink2 = new Drinks("Water 0.5L", 3.5, true, true);
		Drinks drink3 = new Drinks("Coca cola 0.33L", 5, true, true);
		Drinks drink4 = new Drinks("Pepsi 0.33L", 5, true, true);
		Drinks drink5 = new Drinks("Mirinda 0.33L", 5, true, false);
		Drinks drink6 = new Drinks("Fanta 0.33L", 5, true, false);
		Drinks drink7 = new Drinks("Orange juice 0.2L", 3, true, false);
		Drinks drink8 = new Drinks("Apple juice 0.2L", 3, true, false);
		Drinks drink9 = new Drinks("Bear 0.3L", 5, false, false);
		Drinks drink10 = new Drinks("Bear 0.5L", 7, false, false);
		Drinks drink11 = new Drinks("Red Wine 0.2L", 10, false, false);
		Drinks drink12 = new Drinks("White Wine 0.2L", 11, false, false);

		entityManager.getTransaction().begin();

		entityManager.persist(cuisinePL);
		entityManager.persist(cuisineMX);
		entityManager.persist(cuisineIT);

		entityManager.persist(foodPL1);
		entityManager.persist(foodPL2);
		entityManager.persist(foodPL3);
		entityManager.persist(foodPL4);
		entityManager.persist(foodPL5);
		entityManager.persist(foodPL6);
		entityManager.persist(foodPL7);
		entityManager.persist(foodPL8);
		entityManager.persist(foodPL9);
		entityManager.persist(foodPL10);

		entityManager.persist(foodMX1);
		entityManager.persist(foodMX2);
		entityManager.persist(foodMX3);
		entityManager.persist(foodMX4);
		entityManager.persist(foodMX5);
		entityManager.persist(foodMX6);
		entityManager.persist(foodMX7);
		entityManager.persist(foodMX8);
		entityManager.persist(foodMX9);
		entityManager.persist(foodMX10);

		entityManager.persist(foodIT1);
		entityManager.persist(foodIT2);
		entityManager.persist(foodIT3);
		entityManager.persist(foodIT4);
		entityManager.persist(foodIT5);
		entityManager.persist(foodIT6);
		entityManager.persist(foodIT7);
		entityManager.persist(foodIT8);
		entityManager.persist(foodIT9);
		entityManager.persist(foodIT10);

		entityManager.persist(dessertPL1);
		entityManager.persist(dessertPL2);
		entityManager.persist(dessertPL3);

		entityManager.persist(dessertMX1);
		entityManager.persist(dessertMX2);
		entityManager.persist(dessertMX3);

		entityManager.persist(dessertIT1);
		entityManager.persist(dessertIT2);
		entityManager.persist(dessertIT3);

		entityManager.persist(drink1);
		entityManager.persist(drink2);
		entityManager.persist(drink3);
		entityManager.persist(drink4);
		entityManager.persist(drink5);
		entityManager.persist(drink6);
		entityManager.persist(drink7);
		entityManager.persist(drink8);
		entityManager.persist(drink9);
		entityManager.persist(drink10);
		entityManager.persist(drink11);
		entityManager.persist(drink12);

		entityManager.getTransaction().commit();
	}
}
