package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

@Entity
public class Foods implements FoodsAndDrinks {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	@Lob
	@Type(type = "org.hibernate.type.TextType")
	private String description;
	private double price;

	@ManyToOne
	@JoinColumn(name = "cuisineID")
	private Cuisine cuisine;

	public Foods() {

	}

	public Foods(String name, String description, double price, Cuisine cuisine) {
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
