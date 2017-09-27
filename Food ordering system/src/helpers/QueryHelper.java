package helpers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entities.Cuisine;
import entities.Dessert;
import entities.Drinks;
import entities.Foods;

public class QueryHelper {

	public QueryHelper(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	private EntityManager entityManager;
	
	public List<Cuisine> CuisineQuery(String s){
		TypedQuery<Cuisine> query = entityManager.createQuery(s, Cuisine.class);
		List<Cuisine> queryResults = query.getResultList();
		return queryResults;
	}
	
	public List<Foods> FoodQuery(String s,long cuisine){
		TypedQuery<Foods> queryFoods = entityManager.createQuery(s+ " where cuisineID = ?1",
				Foods.class);
		queryFoods.setParameter(1, cuisine);
		List<Foods> queryFoodsResults = queryFoods.getResultList();
		return queryFoodsResults;
	}
	
	public List<Drinks> DrinksQuery(String s){
		TypedQuery<Drinks> query = entityManager.createQuery(s, Drinks.class);
		List<Drinks> queryResults = query.getResultList();
		return queryResults;
	}
	
	public List<Dessert> DessertQuery(String s,long cuisine){
		TypedQuery<Dessert> queryDessert = entityManager.createQuery(s+ " where cuisineID = ?1",
				Dessert.class);
		queryDessert.setParameter(1, cuisine);
		List<Dessert> queryDessertResults = queryDessert.getResultList();
		return queryDessertResults;
	}
}
