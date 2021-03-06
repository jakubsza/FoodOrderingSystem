package domain;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import helpers.ErrorsDealing;
import working.Client;
import working.Employee;

public class Main {

	public static EntityManagerFactory entityManagerFactory;
	public static EntityManager entityManager;

	public static void main(String[] args) {

		entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		entityManager = entityManagerFactory.createEntityManager();
		Scanner dane;

		Menu menu = new Menu(entityManager);
		Employee employee = new Employee(entityManager);
		Client client = new Client(entityManager);

		// creating menu (basic)
		menu.createMenu();

		System.out.println("Welcome to our restaurant!\nIf you are a client press 1, if you are a employee press 2");

		boolean ok = false;
		int result = 0;

		// try-catch for wrong dates
		while (!ok) {
			result = ErrorsDealing.getIntNumber();
			if (result == 1 || result == 2) {
				ok = true;
			} else {
				System.out.println("You picked wrong number, please pick correct one.");
			}

		}

		switch (result) {
		case 1:
			client.ordering();
			break;
		case 2:
			employee.adding();
			break;
		}

		entityManager.close();
		entityManagerFactory.close();

	}

}
