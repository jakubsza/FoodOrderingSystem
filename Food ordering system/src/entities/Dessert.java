package entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;

@Entity
public class Dessert implements FoodsAndDrinks {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String description;
	private double price;

	@ManyToOne
	@JoinColumn(name = "cuisineID")
	private Cuisine cuisine;

	public Dessert() {

	}

	public Dessert(String name, String description, double price, Cuisine cuisine) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.cuisine = cuisine;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getPrice() {
		return price;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setCuisine(Cuisine cusine) {
		this.cuisine = cusine;
	}

	public Cuisine getCuisine() {
		return cuisine;
	}
}
