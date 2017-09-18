package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Drinks implements FoodsAndDrinks {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	private double price;
	private boolean iceCubes;
	private boolean lemon;

	public Drinks() {

	}

	public Drinks(String name, double price, boolean iceCubes, boolean lemon) {
		this.name = name;
		this.price = price;
		this.iceCubes = iceCubes;
		this.lemon = lemon;
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

	public long getId() {
		return id;
	}

	public boolean getIceCubes() {
		return iceCubes;
	}

	public boolean getLemon() {
		return lemon;
	}

	public void setIceCubes(boolean iceCubes) {
		this.iceCubes = iceCubes;
	}

	public void setLemon(boolean lemon) {
		this.lemon = lemon;
	}
}
