package helpers;

import javax.persistence.EntityManager;

import entities.Cuisine;
import entities.Dessert;
import entities.Drinks;
import entities.Foods;

public class SqlAdding {
	
	public SqlAdding(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	private EntityManager entityManager;

	public void addingToSQL(Foods food) {
		entityManager.getTransaction().begin();
		entityManager.persist(food);
		entityManager.getTransaction().commit();
	}
	
	public void addingToSQL(Cuisine cuisine) {
		entityManager.getTransaction().begin();
		entityManager.persist(cuisine);
		entityManager.getTransaction().commit();
	}

	public void addingToSQL(Drinks drink) {
		entityManager.getTransaction().begin();
		entityManager.persist(drink);
		entityManager.getTransaction().commit();
	}

	public void addingToSQL(Dessert dessert) {
		entityManager.getTransaction().begin();
		entityManager.persist(dessert);
		entityManager.getTransaction().commit();
	}
}
